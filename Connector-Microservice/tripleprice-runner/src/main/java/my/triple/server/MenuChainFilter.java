/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.triple.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import my.triple.ref.ActionType;
import my.triple.services.MenuService;
import my.triple.util.LogUtil;
import my.triple.util.Util;

public class MenuChainFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(MenuChainFilter.class);
	private static final StringBuilder authorityLogs = new StringBuilder();
	private static final String PATH_URI = "/admin/v1/view/";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		/*
		 * injector filter chain to spring
		 */
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
	}

	@Autowired
	private MenuService menuService;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		doFilterMenu(servletRequest, servletResponse, filterChain);
	}

	@Override
	public void destroy() {

	}

	/**
	 * If path = "/admin/v1/api/" not necessary call screen menu
	 * 
	 * @param servletRequest
	 * @param servletResponse
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	private void doFilterMenu(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRquest = (HttpServletRequest) servletRequest;
		String path = httpServletRquest.getRequestURI();
		LogUtil.logDebug(logger, true, "Uri chain filter={}", path);

		if (path.startsWith(PATH_URI)) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			List<String> listAuthorities = new ArrayList<String>();
			for (Object listAuthority : auth.getAuthorities()) {
				listAuthorities.add(listAuthority.toString());
			}

			String listMenu = menuService.getScreenMenu(listAuthorities);
			servletRequest.setAttribute("scriptMenu", listMenu);
			if (Util.isEnableLoggerAccessPage()) {
				logAccessPage(servletRequest, auth, listAuthorities, httpServletRquest, logger);
			}
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	/**
	 * 
	 * @param servletRequest
	 * @param auth
	 * @param listAuthorities
	 * @param logger
	 */
	private static final void logAccessPage(ServletRequest servletRequest, Authentication auth,
			List<String> listAuthorities, HttpServletRequest httpServletRquest, Logger logger) {

		String name = auth.getName();
		for (int a = 0; a < listAuthorities.size(); a++) {
			authorityLogs.append(listAuthorities.get(a));
			if (a < (listAuthorities.size() - 1)) {
				authorityLogs.append(",");
			}
		}
		LogUtil.logDebugType(logger, true, ActionType.ACCESS_PAGE, "Login={}, Access page={}, Authorities={}", name,
				httpServletRquest.getRequestURI(), authorityLogs);
		authorityLogs.delete(0, authorityLogs.length());
	}
}
