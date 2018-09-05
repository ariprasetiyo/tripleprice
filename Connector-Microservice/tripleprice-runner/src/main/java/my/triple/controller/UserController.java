package my.triple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import my.triple.services.RolesService;

@Controller
@RequestMapping("/admin/v1/view/user")
public class UserController {

    @Autowired
    RolesService rolesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("selectroles", rolesService.viewSysRoleAll());
//        model.addAttribute("usersMenu", userService.listUser(0, 10, ""));
        //return "/admin/v1/pages/user-index";
        return "/admin/v1/spa/templates/user-index.html";
    }

}
