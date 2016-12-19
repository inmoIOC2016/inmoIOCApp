package com.inmoioc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inmoioc.model.User;
import com.inmoioc.service.UserService;
import com.inmoioc.utils.Constants;

/**
 * Controlador que carrega el model de dades e invoca a la vista utilitzat al login
 * @author: Sonia Carrillo Mañas
 */

@Controller
public class UserController {
	
	@Autowired
	UserService userService;	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, headers = "Accept=application/json")
	public String login(Model model) {
		model.addAttribute("message", "");
		model.addAttribute("loginStatus", "false");
		model.addAttribute("user", new User());
		return "login";		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET, headers = "Accept=application/json")
	public String logout(Model model) {
		model.addAttribute("message", "");
		model.addAttribute("loginStatus", "false");
		model.addAttribute("user", new User());
		return "login";		
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String getUser(@ModelAttribute("user") User user, Model model) {	
		User findUser = userService.getUser(user.getUsername(), user.getPassword());
		if(findUser!=null){
			model.addAttribute("message", "");
			model.addAttribute("loginStatus", "true");
			model.addAttribute("userName", findUser.getUsername());
			model.addAttribute("user", findUser);
			if(findUser.getRights().toUpperCase().equals(Constants.RIGHTS_TYPE_USER_SUPERADMIN) || 
					findUser.getRights().toUpperCase().equals(Constants.RIGHTS_TYPE_USER_ADMIN)){
				return "gestioAdmin";
			} else {
				return "gestioUser";
			}
		} else {
			model.addAttribute("message", "Usuari o password incorrecte");
			model.addAttribute("loginStatus", "false");
			return "login";
		}
	}
}