package com.inmoioc.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.inmoioc.model.Category;
import com.inmoioc.model.Property;
import com.inmoioc.model.SellType;
import com.inmoioc.model.Selling;
import com.inmoioc.model.User;
import com.inmoioc.service.ManagementService;

/**
 * Controlador que carrega el model de dades e invoca a la vista utilitzat al menu per els usuaris amb ROL admin 
 * @author: Sonia Carrillo Mañas, Iván Soto Román
 */

@Controller
@SessionAttributes({"userName","loginStatus","rights"}) //variables de sessio
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
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Tots ");
		
		return "management/property";
	}
	
	@RequestMapping(value = "/findPropertyById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findPropertyById(@PathVariable("id") int id, Model model) {
		List<Property> list = new ArrayList();
		Property entity = managementService.getPropertyById(id);
	    if(entity!=null){
	    	list.add(entity);
	    }
		model.addAttribute("property", new Property());
		model.addAttribute("propertyList", list);
		
		List<Category> list1 = managementService.getAllCategory();		
		model.addAttribute("categoryList", list1);
		
		List<SellType> list2 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list2);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Id: " + id + " ) ");
		
	    return "management/property";
	}
	
	@RequestMapping(value = "/findPropertyByName/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findPropertyByName(@PathVariable("name") String name, Model model) {		
		List<Property> list = managementService.getPropertyByName(name);	    
		model.addAttribute("property", new Property());
		model.addAttribute("propertyList", list);
		
		List<Category> list1 = managementService.getAllCategory();		
		model.addAttribute("categoryList", list1);
		
		List<SellType> list2 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list2);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Nom: " + name + " ) ");
		
	    return "management/property";
	}
	
	@RequestMapping(value = "/findProperty/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findProperty(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
	    List<Property> list = managementService.getProperty(id, name);
		model.addAttribute("property", new Property());
		model.addAttribute("propertyList", list);
		
		List<Category> list1 = managementService.getAllCategory();		
		model.addAttribute("categoryList", list1);
		
		List<SellType> list2 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list2);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre( Id: " + id + " - Nom: " + name + " ) ");
		
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
		 model.addAttribute("property", this.managementService.getPropertyById(id));
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
		model.addAttribute("filter", "Resultat: " + list.size() + " - Tots ");
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
		 model.addAttribute("category", this.managementService.getCategoryById(id));
	     model.addAttribute("categoryList", this.managementService.getAllCategory());	    
	     return "management/category";
	}

	@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCategory(@PathVariable("id") int id) {
		managementService.deleteCategory(id);
		return "redirect:/categories";
	}
	
	@RequestMapping(value = "/findCategoryById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findCategoryById(@PathVariable("id") int id, Model model) {
		List<Category> list = new ArrayList();
	    Category entity = managementService.getCategoryById(id);
	    if(entity!=null){
	    	list.add(entity);
	    }
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", list);
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Id: " + id + " ) ");
	    return "management/category";
	}
	
	@RequestMapping(value = "/findCategoryByName/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findCategoryByName(@PathVariable("name") String name, Model model) {		
		List<Category> list = managementService.getCategoryByName(name);	    
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", list);
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Nom: " + name + " ) ");
	    return "management/category";
	}
	
	@RequestMapping(value = "/findCategory/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findCategory(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
	    List<Category> list = managementService.getCategory(id, name);
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", list);
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre( Id: " + id + " - Nom: " + name + " ) ");
	    return "management/category";
	}
	
	// USER
	
	@RequestMapping(value = "/usuaris", method = RequestMethod.GET, headers = "Accept=application/json")
	public String usuaris(Model model) {
		List<User> list = managementService.getAllUser();
		model.addAttribute("user", new User());
		model.addAttribute("userList", list);
		model.addAttribute("filter", "Resultat: " + list.size() + " - Tots ");
		return "management/user";
	}
	
	@RequestMapping(value = "/findUserById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findUserById(@PathVariable("id") int id, Model model) {
		List<User> list = new ArrayList();
		User entity = managementService.getUserById(id);
	    if(entity!=null){
	    	list.add(entity);
	    }
		model.addAttribute("user", new User());
		model.addAttribute("userList", list);
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Id: " + id + " ) ");
	    return "management/user";
	}
	
	@RequestMapping(value = "/findUserByName/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findUserByName(@PathVariable("name") String name, Model model) {		
		List<User> list = managementService.getUserByName(name);	    
		model.addAttribute("user", new User());
		model.addAttribute("userList", list);
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Nom: " + name + " ) ");
	    return "management/user";
	}
	
	@RequestMapping(value = "/findUser/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findUser(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
	    List<User> list = managementService.getUser(id, name);
		model.addAttribute("user", new User());
		model.addAttribute("userList", list);
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre( Id: " + id + " - Nom: " + name + " ) ");
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
		 model.addAttribute("user", this.managementService.getUserById(id));
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
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Tots ");
		
		return "management/selling";
	}
	
	@RequestMapping(value = "/findSellingById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findSellingById(@PathVariable("id") int id, Model model) {
		List<Selling> list = new ArrayList();
		Selling entity = managementService.getSellingById(id);
	    if(entity!=null){
	    	list.add(entity);
	    }
		model.addAttribute("selling", new Selling());
		model.addAttribute("sellingList", list);
		
		List<User> list1 = managementService.getAllUser();		
		model.addAttribute("userList", list1);
		
		List<Property> list2 = managementService.getAllProperty();		
		model.addAttribute("propertyList", list2);
		
		List<SellType> list3 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list3);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Id: " + id + " ) ");
	    return "management/selling";
	}
	
	@RequestMapping(value = "/findSellingByName/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findSellingByName(@PathVariable("name") String name, Model model) {		
		List<Selling> list = managementService.getSellingByName(name);	    
		model.addAttribute("selling", new Selling());
		model.addAttribute("sellingList", list);
		
		List<User> list1 = managementService.getAllUser();		
		model.addAttribute("userList", list1);
		
		List<Property> list2 = managementService.getAllProperty();		
		model.addAttribute("propertyList", list2);
		
		List<SellType> list3 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list3);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Nom: " + name + " ) ");
	    return "management/selling";
	}
	
	@RequestMapping(value = "/findSelling/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findSelling(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
	    List<Selling> list = managementService.getSelling(id, id);
		model.addAttribute("selling", new Property());
		model.addAttribute("sellingList", list);
		
		List<User> list1 = managementService.getAllUser();		
		model.addAttribute("userList", list1);
		
		List<Property> list2 = managementService.getAllProperty();		
		model.addAttribute("propertyList", list2);
		
		List<SellType> list3 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list3);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre( Id: " + id + " - Nom: " + name + " ) ");
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
		 model.addAttribute("selling", this.managementService.getSellingById(id));
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
	
	// COMPRA
	
	@RequestMapping(value = "/compra", method = RequestMethod.GET, headers = "Accept=application/json")
	public String compra(Model model) {		
		return "portada/compra";
	}
		
	// LLOGUER
		
	@RequestMapping(value = "/lloguer", method = RequestMethod.GET, headers = "Accept=application/json")
	public String venta(Model model) {		
		return "portada/lloguer";
	}
	
	// REGISTRATION USER
	
	@RequestMapping(value = "/addUserRegistration", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUserRegistration(@ModelAttribute("user") User user, Model model) {
		boolean isValid = true;
		model.addAttribute("user", user);
		if(user.getId_user()==0 && !user.getUsername().isEmpty() && !user.getPassword().isEmpty() && !user.getEmail().isEmpty())
		{
			String userName = user.getUsername().trim();
			String password = user.getPassword().trim();
			String email = user.getEmail().trim();			
			
			List<User> users = managementService.getUserByUserNameAndEmail(userName, email);
			if(users!=null && users.size()>0) {
				model.addAttribute("message", "Error: Aquest usuari ja existeix");
				isValid = false;
			} else {
						        
		        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		        Matcher mather = pattern.matcher(email);
		 
		        if (mather.find() == true) {
		        	user.setUsername(userName);
					user.setPassword(password);
					user.setEmail(email);
					user.setRights("user");
					java.util.Date myDate = new java.util.Date();			
				    java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
					user.setRegistration_date(sqlDate);
					managementService.addUser(user);
		        } else {
		        	model.addAttribute("message", "Error: Email no vàlid");
					isValid = false;
		        }				
				
			}
		}
		else
		{
			model.addAttribute("message", "Error: Dades Incorrectes");
			isValid = false;
		}
		
		if(isValid){			
			return "redirect:/registrationok";
		} else {
			return "registration";			
		}
	}
		
}