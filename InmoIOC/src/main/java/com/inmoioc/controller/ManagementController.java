package com.inmoioc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inmoioc.model.Category;
import com.inmoioc.model.Property;
import com.inmoioc.model.SellType;
import com.inmoioc.model.Selling;
import com.inmoioc.model.User;
import com.inmoioc.service.ManagementService;

/**
 * Controlador que carrega el model de dades e invoca a la vista utilitzat al menu per els usuaris amb ROL admin 
 * @author: Sonia Carrillo Mañas
 */

@Controller
public class ManagementController {
	
	@Autowired
	ManagementService managementService;
	
	// PRINCIPAL
	
	@RequestMapping(value = "/principal", method = RequestMethod.GET, headers = "Accept=application/json")
	public String principal(Model model) {		
		//model.addAttribute("principal", new Principal());
		return "management/principal";
	}
	
	// PROPERTY
	
	@RequestMapping(value = "/inmobles", method = RequestMethod.GET, headers = "Accept=application/json")
	public String inmobles(Model model) {
				
		List<Property> list = managementService.getAllProperty();
		model.addAttribute("property", new Property());
		model.addAttribute("propertyList", list);
		
		List<Category> list1 = managementService.getAllCategory();		
		model.addAttribute("categoryList", list1);
		
		List<SellType> list2 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list2);
		
		return "management/property";
	}
	
	@RequestMapping(value = "/addProperty", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addProperty(@ModelAttribute("property") Property property) {	
		if(property.getId_property()==0)
		{
			managementService.addProperty(property);
		}
		else
		{	
			managementService.updateProperty(property);
		}
		
		return "redirect:/inmobles";
	}

	@RequestMapping(value = "/updateProperty/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateProperty(@PathVariable("id") int id, Model model) {
		 model.addAttribute("property", this.managementService.getProperty(id));
	     model.addAttribute("propertyList", this.managementService.getAllProperty());
	     
	     List<Category> list1 = managementService.getAllCategory();		
		 model.addAttribute("categoryList", list1);
			
		 List<SellType> list2 = managementService.getAllSellType();
		 model.addAttribute("sellTypeList", list2);
	     return "management/property";
	}

	@RequestMapping(value = "/deleteProperty/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteProperty(@PathVariable("id") int id) {
		managementService.deleteProperty(id);
		return "redirect:/inmobles";
	}
	
	// CATEGORY
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET, headers = "Accept=application/json")
	public String categories(Model model) {
		List<Category> list = managementService.getAllCategory();
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", list);		
		return "management/category";
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCategory(@ModelAttribute("category") Category category) {	
		if(category.getId_category()==0)
		{
			managementService.addCategory(category);
		}
		else
		{	
			managementService.updateCategory(category);
		}
		
		return "redirect:/categories";
	}

	@RequestMapping(value = "/updateCategory/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCategory(@PathVariable("id") int id, Model model) {
		 model.addAttribute("category", this.managementService.getCategory(id));
	     model.addAttribute("categoryList", this.managementService.getAllCategory());	    
	     return "management/category";
	}

	@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCategory(@PathVariable("id") int id) {
		managementService.deleteCategory(id);
		return "redirect:/categories";
	}
	
	// USER
	
	@RequestMapping(value = "/usuaris", method = RequestMethod.GET, headers = "Accept=application/json")
	public String usuaris(Model model) {
		List<User> list = managementService.getAllUser();
		model.addAttribute("user", new User());
		model.addAttribute("userList", list);		
		return "management/user";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUser(@ModelAttribute("user") User user) {
		if(user.getId_user()==0)
		{
			managementService.addUser(user);
		}
		else
		{	
			managementService.updateUser(user);
		}
		
		return "redirect:/usuaris";
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateUser(@PathVariable("id") int id, Model model) {
		 model.addAttribute("user", this.managementService.getUser(id));
	     model.addAttribute("userList", this.managementService.getAllUser());	    
	     return "management/user";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteUser(@PathVariable("id") int id) {
		managementService.deleteUser(id);
		return "redirect:/usuaris";
	}
	
	// SELLING
	
	@RequestMapping(value = "/vendes", method = RequestMethod.GET, headers = "Accept=application/json")
	public String transaccions(Model model) {
		List<Selling> list = managementService.getAllSelling();
		model.addAttribute("selling", new Selling());
		model.addAttribute("sellingList", list);
		
		List<User> list1 = managementService.getAllUser();		
		model.addAttribute("userList", list1);
		
		List<Property> list2 = managementService.getAllProperty();		
		model.addAttribute("propertyList", list2);
		
		List<SellType> list3 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list3);
		
		return "management/selling";
	}
	
	@RequestMapping(value = "/addSelling", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addSelling(@ModelAttribute("selling") Selling selling) {	
		if(selling.getId_selling()==0)
		{
			managementService.addSelling(selling);
		}
		else
		{	
			managementService.updateSelling(selling);
		}
		
		return "redirect:/vendes";
	}

	@RequestMapping(value = "/updateSelling/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateSelling(@PathVariable("id") int id, Model model) {
		 model.addAttribute("selling", this.managementService.getSelling(id));
	     model.addAttribute("sellingList", this.managementService.getAllSelling());
	     
	     List<User> list1 = managementService.getAllUser();		
		 model.addAttribute("userList", list1);
			
		 List<Property> list2 = managementService.getAllProperty();		
		 model.addAttribute("propertyList", list2);
			
		 List<SellType> list3 = managementService.getAllSellType();
		 model.addAttribute("sellTypeList", list3);
			
	     return "management/selling";
	}

	@RequestMapping(value = "/deleteSelling/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteSelling(@PathVariable("id") int id) {
		managementService.deleteSelling(id);
		return "redirect:/vendes";
	}
	
	// STADISTICS
	
	@RequestMapping(value = "/estadistica", method = RequestMethod.GET, headers = "Accept=application/json")
	public String estadistica(Model model) {		
		return "management/stadistic";
	}
		
}