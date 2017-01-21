package com.inmoioc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Controlador que carrega el model de dades e invoca a les vistes utilitzades a la web
 * @author: Sonia Carrillo Mañas - Iván Soto Román - Albert Conesa Garcia
 */

@Controller
@SessionAttributes({"userName","loginStatus","rights"}) //variables de sessio
public class WebController {
	
	@RequestMapping(value = "/web", method = RequestMethod.GET, headers = "Accept=application/json")
	public String web() {
		return "web";
	}
	
	@RequestMapping(value = "/weblegal", method = RequestMethod.GET, headers = "Accept=application/json")
	public String weblegal() {
		return "weblegal";
	}
	
	@RequestMapping(value = "/webnews", method = RequestMethod.GET, headers = "Accept=application/json")
	public String webnews() {
		return "webnews";
	}
	
	@RequestMapping(value = "/webcontact", method = RequestMethod.GET, headers = "Accept=application/json")
	public String webcontact() {
		return "webcontact";
	}
	
}