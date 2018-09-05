/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.triple.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import my.triple.services.AuthorizationService;
import my.triple.services.RolesService;

@Controller
@RequestMapping("/admin/v1/view/authorization")
public class AuthorizationController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RolesService rolesService;

	@Autowired
	AuthorizationService authorizationService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		// authorizationService.viewSysRoles(model, null);
		model.addAttribute("selectroles", rolesService.viewSysRoleAll());
		model.addAttribute("listMenu", authorizationService.listMenu());
		model.addAttribute("listMenuAuthorization", authorizationService.listMenuAuthorization(1L));
		// return "/admin/v1/pages/authorization-index";
		// authorizationService.viewDataMenu(model,1L);
		return "/admin/v1/spa/templates/authorization-index.html";
	}

	// @RequestMapping(value = "", method = RequestMethod.POST)
	// public String index(Model model, Pageable page,
	// @RequestParam(value = "roles_id", required = false) Long idRole) {
	// authorizationService.viewSysRoles(model, idRole);
	// //authorizationService.viewDataMenu(model, idRole);
	// //authorizationService.existingMenuInSysMenu(model);
	// //authorizationService.existingMenuInAuthorization(model, idRole);
	// //return "/admin/v1/pages/authorization-index";
	// return "/admin/v1/spa/templates/authorization-index";
	// }
}
