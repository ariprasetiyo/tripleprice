/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripleprice.server;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import tripleprice.dao.AuthorizationDao;
import tripleprice.dto.AuthorizationDto;

@Configuration
@EnableWebSecurity
public class ConfigurationSecurity extends WebSecurityConfigurerAdapter {

	private static final String SQL_LOGIN = "select username, password, is_active as enabled from sys_user where username = ? and is_active = true  ;";

	private static final String SQL_PERMISSION = "select u.username as username, r.role_name as authority "
			+ "from sys_user u join sys_user_roles ur on u.id = ur.sys_user_id "
			+ "join sys_roles r on ur.sys_roles_id = r.id where u.username = ? ;";

	// Logger log = Logger.getLogger(ConfigurationSecurity.class);
	@Autowired
	private DataSource ds;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication()
		// .withUser("ari").password("ari").roles("admin")
		// .and()
		// .withUser("a").password("a").roles("user").
		// and().withUser("b").password("b").roles("public")
		// .and().withUser("c").password("c").roles("c");

		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("ari").password("ari").roles("admin") .and()
		 * .withUser("a").password("a").roles("user").
		 * and().withUser("b").password("b").roles("public")
		 * .and().withUser("c").password("c").roles("c");
		 */

		auth.jdbcAuthentication().dataSource(ds).passwordEncoder(NoOpPasswordEncoder.getInstance())
				.usersByUsernameQuery(SQL_LOGIN).authoritiesByUsernameQuery(SQL_PERMISSION);

	}

	@Autowired
	AuthorizationDao authorizationDao;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		List<AuthorizationDto> sysAuthorizations = authorizationDao.listRolenameAndDispatcherUrl();

		MultiValueMap map = new MultiValueMap();
		for (AuthorizationDto sysAuthorization : sysAuthorizations) {
			map.put(sysAuthorization.getUrl(), sysAuthorization.getRoleName());
		}

		for (Object key : map.keySet()) {
			String[] roleName = map.get(key).toString().replaceAll("\\[|\\]|\\s", "").split(",");
			httpSecurity.authorizeRequests().antMatchers(key.toString()).hasAnyAuthority(roleName);
		}

		/*
		 * for while CSRF token protection disabled
		 */
		httpSecurity.authorizeRequests()
				// .antMatchers("/dashboard/**").hasAnyAuthority("admin")
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				// defaultSuccessUrl is user success login then foward to hallo
				// and boolean true is user login direct access hallo, if false
				// call back user before login
				.defaultSuccessUrl("/admin/v1/view/main#/", true).and().logout().and().csrf()
				.disable()/*
							 * csrfTokenRepository(new
							 * HttpSessionCsrfTokenRepository())
							 *//*
							 * and() .addFilterAfter(new
							 * ConfigurationCrsfFilter(),
							 * CsrfFilter.class).csrf()
							 * .csrfTokenRepository(csrfTokenRepository())
							 */;
	}

	@Override
	public void configure(WebSecurity webSecurity) {

		// ignore resource with security access login
		// webSecurity.ignoring().antMatchers("/without_restrict/**", "/login",
		// "/");
		webSecurity.ignoring().antMatchers("/resources/**").antMatchers(HttpMethod.POST, "/admin/v1/security/**");
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}
}
