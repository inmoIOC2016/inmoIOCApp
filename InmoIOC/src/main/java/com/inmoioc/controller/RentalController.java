package com.inmoioc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador que carrega el model de dades e invoca a la vista utilitzat al menu per els usuaris amb ROL user 
 * @author: Sonia Carrillo Mañas
 */

@Controller
public class RentalController {	
	// RENTAL
	
	@RequestMapping(value = "/rental", method = RequestMethod.GET, headers = "Accept=application/json")
	public String rental(Model model) {		
		//model.addAttribute("rental", new Rental());
		return "rental/rental";
	}
}