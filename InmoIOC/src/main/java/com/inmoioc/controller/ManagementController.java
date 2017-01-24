package com.inmoioc.controller;


import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.inmoioc.model.Category;
import com.inmoioc.model.City;
import com.inmoioc.model.Incidence;
import com.inmoioc.model.IncidenceStatus;
import com.inmoioc.model.Payment;
import com.inmoioc.model.Property;
import com.inmoioc.model.Role;
import com.inmoioc.model.SellType;
import com.inmoioc.model.Selling;
import com.inmoioc.model.Status;
import com.inmoioc.model.User;
import com.inmoioc.service.ManagementService;
import com.inmoioc.service.UserService;

/**
 * Controlador que carrega el model de dades e invoca a la vista utilitzat al menu per els usuaris amb ROL admin 
 * @author: Sonia Carrillo Mañas - Iván Soto Román - Albert Conesa Garcia
 */

@Controller
@SessionAttributes({"userName","loginStatus","rights"}) //variables de sessio
public class ManagementController {
	
	@Autowired
	ManagementService managementService;
	
	@Autowired
	UserService userService;
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.registerCustomEditor(byte[].class,new ByteArrayMultipartFileEditor());
	}
	
	
	// PROPERTY
	
	@RequestMapping(value = "/inmobles", method = RequestMethod.GET, headers = "Accept=application/json")
	public String inmobles(Model model) {
				
		List<Property> list = managementService.getAllProperty();				
		
		model.addAttribute("property", new Property());
		model.addAttribute("propertyList", list);
		model.addAttribute("propertyListPublic", propertyPublicAndNotSelling(list));
		
		List<Category> list1 = managementService.getAllCategory();		
		model.addAttribute("categoryList", list1);
		
		List<SellType> list2 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list2);
		
		List<User> list3 = userService.getAllUsers();
		model.addAttribute("userList", list3);
		
		List<City> list4 = managementService.getAllCities();		
		model.addAttribute("citiesList", list4);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Tots ");
		
		return "management/property";
	}
	
	private List<Property> propertyPublic(List<Property> list) {
		List<Property> listFinal = new ArrayList<Property>();
		if(list!=null && list.size()>0){			
			for(int i=0;i<list.size();i++){
				if(list.get(i).getAvailable()!=null && list.get(i).getAvailable()==1){
					listFinal.add(list.get(i));
				}				
			}			
		}		
		return listFinal;
	}
	
	private List<Property> propertyPublicAndNotSelling(List<Property> list) {
		List<Property> listFinal = new ArrayList<Property>();
		if(list!=null && list.size()>0){			
			for(int i=0;i<list.size();i++){
				if(list.get(i).getAvailable()!=null && list.get(i).getAvailable()==1){
					listFinal.add(list.get(i));
				}				
			}			
		}
		List<Selling> list1 = managementService.getAllSelling();
		listFinal = propertyNoSelling(listFinal, list1);
		return listFinal;
	}
	
	private List<Property> propertyNoSelling(List<Property> list, List<Selling> list1) {
		List<Property> listFinal = new ArrayList<Property>();
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				int idProperty = list.get(i).getId_property();
				boolean isSelling = false;
				if(list1!=null && list1.size()>0){
					for(int j=0;j<list1.size();j++){
						if(list1.get(j).getProperty().getId_property() == idProperty){
							isSelling = true;
						}				
					}
				}
				if(!isSelling){
					listFinal.add(list.get(i));
				}
			}			
		}
		return listFinal;
	}
	
	@RequestMapping(value = "/findPropertyById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findPropertyById(@PathVariable("id") int id, Model model) {
		List<Property> list = new ArrayList<Property>();
		Property entity = managementService.getPropertyById(id);
	    if(entity!=null){
	    	list.add(entity);
	    }
		model.addAttribute("property", new Property());
		model.addAttribute("propertyList", list);
		model.addAttribute("propertyListPublic", propertyPublicAndNotSelling(list));
		
		List<Category> list1 = managementService.getAllCategory();		
		model.addAttribute("categoryList", list1);
		
		List<SellType> list2 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list2);
		
		List<User> list3 = userService.getAllUsers();
		model.addAttribute("userList", list3);
		
		List<City> list4 = managementService.getAllCities();		
		model.addAttribute("citiesList", list4);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Id: " + id + " ) ");
		
	    return "management/property";
	}
	
	@RequestMapping(value = "/findPropertyByName/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findPropertyByName(@PathVariable("name") String name, Model model) {		
		List<Property> list = managementService.getPropertyByName(name);	    
		model.addAttribute("property", new Property());
		model.addAttribute("propertyList", list);
		model.addAttribute("propertyListPublic", propertyPublicAndNotSelling(list));
		
		List<Category> list1 = managementService.getAllCategory();		
		model.addAttribute("categoryList", list1);
		
		List<SellType> list2 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list2);
		
		List<User> list3 = userService.getAllUsers();
		model.addAttribute("userList", list3);
		
		List<City> list4 = managementService.getAllCities();		
		model.addAttribute("citiesList", list4);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Nom: " + name + " ) ");
		
	    return "management/property";
	}
	
	@RequestMapping(value = "/findProperty/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findProperty(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
	    List<Property> list = managementService.getProperty(id, name);
		model.addAttribute("property", new Property());
		model.addAttribute("propertyList", list);
		model.addAttribute("propertyListPublic", propertyPublicAndNotSelling(list));
		
		List<Category> list1 = managementService.getAllCategory();		
		model.addAttribute("categoryList", list1);
		
		List<SellType> list2 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list2);
		
		List<User> list3 = userService.getAllUsers();
		model.addAttribute("userList", list3);
		
		List<City> list4 = managementService.getAllCities();		
		model.addAttribute("citiesList", list4);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre( Id: " + id + " - Nom: " + name + " ) ");
		
	    return "management/property";
	}	
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/addProperty", method = RequestMethod.POST)
	public String addProperty(@ModelAttribute("property") Property property, BindingResult result) throws IOException {	
		if(property.getId_property()==0)
		{
			managementService.addProperty(property);
		}
		else
		{	
			managementService.updateProperty(property);
		}
		
		if(property.getAvailable()!=null && property.getAvailable()==1 && property.getReg_selling()!=null && property.getReg_selling()==1){
			List<Property> list = new ArrayList<Property>();
			list.add(property);
			List<Selling> list1 = managementService.getAllSelling();
			List<Property> listFinal = propertyNoSelling(list, list1);
			if(listFinal!=null && listFinal.size()>0){
				Selling selling = new Selling();
				selling.setId_selling(0);
				selling.setUser(property.getUser());
				selling.setProperty(property);
				float price = property.getBase_price();
				float benefit = property.getBase_price() * 10 / 100;
				float finalPrice = price + benefit;
				selling.setExpected_price(finalPrice);
				selling.setSellType(property.getSellType());				
				java.util.Date myDateStart = new java.util.Date();			
			    java.sql.Date sqlDateStart = new java.sql.Date(myDateStart.getTime());
				selling.setDate_start(sqlDateStart);
				java.util.Date myDateEnd = new java.util.Date();	
				myDateEnd.setMonth(6);
			    java.sql.Date sqlDateEnd = new java.sql.Date(myDateEnd.getTime());
				selling.setDate_end(sqlDateEnd);
				
				Status status = managementService.getStatusById(1);
				selling.setStatus(status);
				managementService.addSelling(selling);
			}
		}
		
		return "redirect:/inmobles";
	}

	@RequestMapping(value = "/updateProperty/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateProperty(@PathVariable("id") int id,  Model model) {
		 model.addAttribute("property", this.managementService.getPropertyById(id));
	     model.addAttribute("propertyList", this.managementService.getAllProperty());
	     model.addAttribute("propertyListPublic", propertyPublicAndNotSelling(this.managementService.getAllProperty()));
	     
	     List<Category> list1 = managementService.getAllCategory();		
		 model.addAttribute("categoryList", list1);
			
		 List<SellType> list2 = managementService.getAllSellType();
		 model.addAttribute("sellTypeList", list2);
		 
		 List<User> list3 = userService.getAllUsers();
		 model.addAttribute("userList", list3);
		 
		 List<City> list4 = managementService.getAllCities();		
			model.addAttribute("citiesList", list4);
			
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
		List<Category> list = new ArrayList<Category>();
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
		List<Role> list1 = managementService.getAllRoles();
		model.addAttribute("roleList", list1);
		model.addAttribute("filter", "Resultat: " + list.size() + " - Tots ");
		return "management/user";
	}
	
	@RequestMapping(value = "/findUserById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findUserById(@PathVariable("id") int id, Model model) {
		List<User> list = new ArrayList<User>();
		User entity = managementService.getUserById(id);
	    if(entity!=null){
	    	list.add(entity);
	    }
		model.addAttribute("user", new User());
		model.addAttribute("userList", list);
		List<Role> list1 = managementService.getAllRoles();
		model.addAttribute("roleList", list1);
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Id: " + id + " ) ");
	    return "management/user";
	}
	
	@RequestMapping(value = "/findUserByName/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findUserByName(@PathVariable("name") String name, Model model) {		
		List<User> list = managementService.getUserByName(name);	    
		model.addAttribute("user", new User());
		model.addAttribute("userList", list);
		List<Role> list1 = managementService.getAllRoles();
		model.addAttribute("roleList", list1);
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Nom: " + name + " ) ");
	    return "management/user";
	}
	
	@RequestMapping(value = "/findUser/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findUser(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
	    List<User> list = managementService.getUser(id, name);
		model.addAttribute("user", new User());
		model.addAttribute("userList", list);
		List<Role> list1 = managementService.getAllRoles();
		model.addAttribute("roleList", list1);
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
	    List<Role> list1 = managementService.getAllRoles();
		model.addAttribute("roleList", list1);
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
		model.addAttribute("propertyListPublic", propertyPublic(list2));
		
		List<SellType> list3 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list3);
		
		List<Status> list4 = managementService.getAllStatus();
		model.addAttribute("statusList", list4);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Tots ");
		
		return "management/selling";
	}
	
	@RequestMapping(value = "/findSellingById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findSellingById(@PathVariable("id") int id, Model model) {
		List<Selling> list = new ArrayList<Selling>();
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
		model.addAttribute("propertyListPublic", propertyPublic(list2));
		
		List<SellType> list3 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list3);
		
		List<Status> list4 = managementService.getAllStatus();
		model.addAttribute("statusList", list4);
		
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
		model.addAttribute("propertyListPublic", propertyPublic(list2));
		
		List<SellType> list3 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list3);
		
		List<Status> list4 = managementService.getAllStatus();
		model.addAttribute("statusList", list4);
		
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
		model.addAttribute("propertyListPublic", propertyPublic(list2));
		
		List<SellType> list3 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list3);
		
		List<Status> list4 = managementService.getAllStatus();
		model.addAttribute("statusList", list4);
		
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
		
		if((selling.getStatus().getId_status() == 6 || selling.getStatus().getId_status() == 7 || selling.getStatus().getId_status() == 8) &&
				selling.getUserPayment()!=null){
			Payment payment = new Payment();
			payment.setId_payment(0);
			payment.setSelling(selling);
			payment.setAmount(selling.getExpected_price());			
			java.util.Date myDate = new java.util.Date();			
		    java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
		    payment.setDate_payment(sqlDate);
			managementService.addPayment(payment);
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
		model.addAttribute("propertyListPublic", propertyPublic(list2));
			
		List<SellType> list3 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list3);
		 
		List<Status> list4 = managementService.getAllStatus();
		model.addAttribute("statusList", list4);
			
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
		List<Selling> selling = this.managementService.getAllSelling();
		List<Payment> payment = this.managementService.getAllPayment();
		
		double total = 0;
		double totalReal = 0;
		double percent = 0;
		double totalPayment = 0;
		
		if(selling!=null && selling.size() > 0){
			total = selling.size();
			for(int i=0;i<selling.size();i++){
				int status = selling.get(i).getStatus().getId_status();
				if(status == 6 || status == 7 || status == 8 ){
					totalReal = totalReal + 1;
				}
			}
			try{
				double c1 =  (double)totalReal / (double)total;
				percent = c1 * 100;				
			} catch (Exception e){				
				model.addAttribute("message", "S'ha produït un error.");
			}
		}				
		model.addAttribute("total", total);
		model.addAttribute("totalReal", totalReal);
		model.addAttribute("percent", String.format("%.02f", percent));
		
		if(payment!=null && payment.size() > 0){			
			for(int i=0;i<payment.size();i++){
				try{
					float amount = payment.get(i).getAmount();					
					totalPayment = totalPayment + amount;	
				} catch (Exception e){				
					model.addAttribute("message", "S'ha produït un error.");
				}	
			}			
		}				
		model.addAttribute("totalPayment", String.format("%.02f", totalPayment));
		
		
		return "management/stadistic";
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
			String name = user.getName().trim();
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
					user.setName(name);
					user.setEmail(email);
					// User role id 2
					Role role = managementService.getRoleById(2);
					user.setRole(role);
					java.util.Date myDate = new java.util.Date();			
				    java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
					user.setRegistration_date(sqlDate);
					managementService.addUser(user);
		        } else {
		        	model.addAttribute("message", "Error: Email no v�lid");
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

	// SELLING
	
	@RequestMapping(value = "/pagaments", method = RequestMethod.GET, headers = "Accept=application/json")
	public String pagaments(Model model) {
		List<Payment> list = managementService.getAllPayment();
		
		model.addAttribute("payment", new Payment());
		model.addAttribute("paymentList", list);
		
		List<Selling> list1 = managementService.getAllSelling();		
		model.addAttribute("sellingList", list1);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Tots ");
		
		return "management/payment";
	}
	
	@RequestMapping(value = "/findPaymentById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findPaymentById(@PathVariable("id") int id, Model model) {
		List<Payment> list = new ArrayList<Payment>();
		Payment entity = managementService.getPaymentById(id);
	    if(entity!=null){
	    	list.add(entity);
	    }
	    model.addAttribute("payment", new Payment());
		model.addAttribute("paymentList", list);
		
		List<Selling> list1 = managementService.getAllSelling();		
		model.addAttribute("sellingList", list1);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Id: " + id + " ) ");
	    return "management/payment";
	}
	
	@RequestMapping(value = "/addPayment", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addPayment(@ModelAttribute("payment") Payment payment) {	
		if(payment.getId_payment()==0)
		{
			managementService.addPayment(payment);
		}
		else
		{	
			managementService.updatePayment(payment);
		}
		
		return "redirect:/pagaments";
	}

	@RequestMapping(value = "/updatePayment/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updatePayment(@PathVariable("id") int id, Model model) {
		model.addAttribute("payment", this.managementService.getPaymentById(id));
	    model.addAttribute("paymentList", this.managementService.getAllPayment());
	    
		List<Selling> list1 = managementService.getAllSelling();		
		model.addAttribute("sellingList", list1);
			
	    return "management/pagaments";
	}

	@RequestMapping(value = "/deletePayment/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deletePayment(@PathVariable("id") int id) {
		managementService.deletePayment(id);
		return "redirect:/pagaments";
	}

	// INCIDENCE
	
	@RequestMapping(value = "/incidencies", method = RequestMethod.GET, headers = "Accept=application/json")
	public String incidencies(Model model) {
		List<Incidence> list = managementService.getAllIncidence();
		model.addAttribute("incidence", new Incidence());
		model.addAttribute("incidenceList", list);
		
		List<User> list1 = managementService.getAllUser();		
		model.addAttribute("userList", list1);
		
		List<IncidenceStatus> list2 = managementService.getAllIncidenceStatus();
		model.addAttribute("incidenceStatusList", list2);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Tots ");
		
		return "management/incidence";
	}
	
	@RequestMapping(value = "/findIncidenceById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findIncidenceById(@PathVariable("id") int id, Model model) {
		List<Incidence> list = new ArrayList<Incidence>();
		Incidence entity = managementService.getIncidenceById(id);
	    if(entity!=null){
	    	list.add(entity);
	    }
		model.addAttribute("incidence", new Incidence());
		model.addAttribute("incidenceList", list);
		
		List<User> list1 = managementService.getAllUser();		
		model.addAttribute("userList", list1);
		
		List<IncidenceStatus> list2 = managementService.getAllIncidenceStatus();
		model.addAttribute("incidenceStatusList", list2);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Id: " + id + " ) ");
	    return "management/incidence";
	}
	
	@RequestMapping(value = "/findIncidenceByName/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findIncidenceByName(@PathVariable("name") String name, Model model) {		
		List<Incidence> list = managementService.getIncidenceByName(name);	    
		model.addAttribute("incidence", new Incidence());
		model.addAttribute("incidenceList", list);
		
		List<User> list1 = managementService.getAllUser();		
		model.addAttribute("userList", list1);
		
		List<IncidenceStatus> list2 = managementService.getAllIncidenceStatus();
		model.addAttribute("incidenceStatusList", list2);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre ( Nom: " + name + " ) ");
	    return "management/incidence";
	}
	
	@RequestMapping(value = "/findIncidence/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findIncidence(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
	    List<Incidence> list = managementService.getIncidence(id, name);
		model.addAttribute("incidence", new Incidence());
		model.addAttribute("incidenceList", list);
		
		List<User> list1 = managementService.getAllUser();		
		model.addAttribute("userList", list1);
		
		List<IncidenceStatus> list2 = managementService.getAllIncidenceStatus();
		model.addAttribute("incidenceStatusList", list2);
		
		model.addAttribute("filter", "Resultat: " + list.size() + " - Filtre( Id: " + id + " - Nom: " + name + " ) ");
	    return "management/incidence";
	}	
	
	@RequestMapping(value = "/addIncidence", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addIncidence(@ModelAttribute("incidence") Incidence incidence, BindingResult result) {	
		if(incidence.getId_incidence()==0)
		{
			managementService.addIncidence(incidence);
		}
		else
		{	
			managementService.updateIncidence(incidence);
		}
		
		return "redirect:/incidencies";
	}

	@RequestMapping(value = "/updateIncidence/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateIncidence(@PathVariable("id") int id, Model model) {
		model.addAttribute("incidence", this.managementService.getIncidenceById(id));
	    model.addAttribute("incidenceList", this.managementService.getAllIncidence());
	     
	    List<User> list1 = managementService.getAllUser();		
		model.addAttribute("userList", list1);
			
		List<IncidenceStatus> list2 = managementService.getAllIncidenceStatus();
		model.addAttribute("incidenceStatusList", list2);
			
	    return "management/incidence";
	}

	@RequestMapping(value = "/deleteIncidence/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteIncidence(@PathVariable("id") int id) {
		managementService.deleteIncidence(id);
		return "redirect:/incidencies";
	}
	
	// INCIDENCE USER
	
	@RequestMapping(value = "/findIncidenceByUsername/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findIncidenceByUsername(@PathVariable("name") String name, Model model) {
		
		List<User> list1 = managementService.getUser(null,name);
		model.addAttribute("userList", list1);
		
		int idUser = 0;
		if(list1!=null && list1.size()>0){
			idUser = list1.get(0).getId_user();
		}
		
		List<Incidence> list = managementService.getIncidenceByIdUser(idUser);
		model.addAttribute("incidence", new Incidence());
		model.addAttribute("incidenceList", list);
		
		List<IncidenceStatus> list2 = managementService.getAllIncidenceStatus();
		model.addAttribute("incidenceStatusList", list2);
		
		model.addAttribute("filter", "");
	    return "userintranet/incidence";
	}
	
	@RequestMapping(value = "/addIncidenceUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addIncidenceUser(@ModelAttribute("incidence") Incidence incidence) {	
		if(incidence.getId_incidence()==0)
		{
			managementService.addIncidence(incidence);
		}
		User user = managementService.getUserById(incidence.getUser().getId_user());		
		return "redirect:/findIncidenceByUsername/" + user.getUsername();
	}
	
	// PROPERTY USER (SELL)
	
	@RequestMapping(value = "/findPropertyByUsername/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findPropertyByUsername(@PathVariable("name") String name, Model model) {
		
		List<User> list3 = managementService.getUser(null,name);
		model.addAttribute("userList", list3);
		
		int idUser = 0;
		if(list3!=null && list3.size()>0){
			idUser = list3.get(0).getId_user();
		}
		
		List<Property> list = managementService.getPropertyByIdUser(idUser);
		model.addAttribute("property", new Property());
		model.addAttribute("propertyList", list);
		model.addAttribute("propertyListPublic", propertyPublicAndNotSelling(list));
		
		List<Category> list1 = managementService.getAllCategory();		
		model.addAttribute("categoryList", list1);
		
		List<SellType> list2 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list2);
		
		List<City> list4 = managementService.getAllCities();		
		model.addAttribute("citiesList", list4);
		
		model.addAttribute("filter", "");
		
	    return "userintranet/sell";
	}
	
	@RequestMapping(value = "/addPropertyUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addPropertyUser(@ModelAttribute("property") Property property) {	
		if(property.getId_property()==0)
		{
			managementService.addProperty(property);
		}
		User user = managementService.getUserById(property.getUser().getId_user());		
		return "redirect:/findPropertyByUsername/" + user.getUsername();
	}
	
	// SELLING USER (PURCHASE)
	
	@RequestMapping(value = "/findSellingByUsernameP/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findSellingByUsernameP(@PathVariable("name") String name, Model model) {
		
		List<User> list1 = managementService.getUser(null,name);
		model.addAttribute("userList", list1);
		
		int idUser = 0;
		if(list1!=null && list1.size()>0){
			idUser = list1.get(0).getId_user();
		}
		
		List<Selling> list = managementService.getSellingByIdUser(idUser, false);
		model.addAttribute("selling", new Selling());
		model.addAttribute("sellingList", list);
		
		List<Property> list2 = managementService.getAllProperty();		
		model.addAttribute("propertyList", list2);
		model.addAttribute("propertyListPublic", propertyPublicAndNotSelling(list2));
		
		List<SellType> list3 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list3);
		
		List<Status> list4 = managementService.getAllStatus();
		model.addAttribute("statusList", list4);
		
		model.addAttribute("filter", "");
		
	    return "userintranet/purchase";
	}
	
	@RequestMapping(value = "/findSellingByUsernameS/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findSellingByUsernameS(@PathVariable("name") String name, Model model) {
		
		List<User> list1 = managementService.getUser(null,name);
		model.addAttribute("userList", list1);
		
		int idUser = 0;
		if(list1!=null && list1.size()>0){
			idUser = list1.get(0).getId_user();
		}
		
		List<Selling> list = managementService.getSellingByIdUser(idUser, true);
		model.addAttribute("selling", new Selling());
		model.addAttribute("sellingList", list);
		
		List<Property> list2 = managementService.getAllProperty();		
		model.addAttribute("propertyList", list2);
		model.addAttribute("propertyListPublic", propertyPublicAndNotSelling(list2));
		
		List<SellType> list3 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list3);
		
		List<Status> list4 = managementService.getAllStatus();
		model.addAttribute("statusList", list4);
		
		model.addAttribute("filter", "");
		
	    return "userintranet/selluser";
	}
	
	// RESERVE
	
	@RequestMapping(value = "/updateSellingReserve/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateSellingReserve(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
		List<User> list1 = managementService.getUser(null,name);
		model.addAttribute("userList", list1);
		
		int idUser = 0;
		if(list1!=null && list1.size()>0){
			idUser = list1.get(0).getId_user();
		}
		
		Selling reserve = managementService.getSellingById(id);
		if(reserve!=null){
			Status status = managementService.getStatusById(5);
			if(status!=null)reserve.setStatus(status);
			User user = managementService.getUserById(idUser);
			if(user!=null) reserve.setUserPayment(user);
			managementService.updateSelling(reserve);
			model.addAttribute("message", "Reservat correctament. Es posaran en contacte amb vostè aviat.");
		}
		
		List<Selling> list = managementService.getSellingByIdUser(idUser, false);
		model.addAttribute("selling", new Selling());
		model.addAttribute("sellingList", list);
		
		List<Property> list2 = managementService.getAllProperty();		
		model.addAttribute("propertyList", list2);
		model.addAttribute("propertyListPublic", propertyPublicAndNotSelling(list2));
		
		List<SellType> list3 = managementService.getAllSellType();
		model.addAttribute("sellTypeList", list3);
		
		List<Status> list4 = managementService.getAllStatus();
		model.addAttribute("statusList", list4);
		
		model.addAttribute("filter", "");
		
	    return "portada/principal";
	}
	
	// COMPRA
	
	@RequestMapping(value = "/compra", method = RequestMethod.GET, headers = "Accept=application/json")
	public String compra(Model model) {	
		List<Property> list = managementService.getPropertyWebsite(1);	
		model.addAttribute("property", new Property());
		model.addAttribute("propertyList", list);
		
		List<Category> list1 = managementService.getAllCategory();		
		model.addAttribute("categoryList", list1);
		
		List<City> list4 = managementService.getAllCities();		
		model.addAttribute("citiesList", list4);
		
		return "portada/compra";
	}
	
	// LLOGUER
		
	@RequestMapping(value = "/lloguer", method = RequestMethod.GET, headers = "Accept=application/json")
	public String lloguer(Model model) {	
		List<Property> list = managementService.getPropertyWebsite(2);	
		model.addAttribute("property", new Property());
		model.addAttribute("propertyList", list);
		
		List<Category> list1 = managementService.getAllCategory();		
		model.addAttribute("categoryList", list1);
		
		List<City> list4 = managementService.getAllCities();		
		model.addAttribute("citiesList", list4);
		
		return "portada/lloguer";
	}
	
	// TRASPÀS
	
	@RequestMapping(value = "/traspas", method = RequestMethod.GET, headers = "Accept=application/json")
	public String traspàs(Model model) {	
		List<Property> list = managementService.getPropertyWebsite(3);	
		model.addAttribute("property", new Property());
		model.addAttribute("propertyList", list);
		
		List<Category> list1 = managementService.getAllCategory();		
		model.addAttribute("categoryList", list1);
		
		List<City> list4 = managementService.getAllCities();		
		model.addAttribute("citiesList", list4);
		
		return "portada/traspas";
	}
	
	// PRINCIPAL
	
	@RequestMapping(value = "/principal", method = RequestMethod.GET, headers = "Accept=application/json")
	public String principal(Model model) {	
		return "portada/principal";
	}
	
	// PRODUCT PAGE
	
	@RequestMapping(value = "/productpage/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String findSellingByUsernameP(@PathVariable("id") int id, Model model) {
		Property entity = managementService.getPropertyById(id);
		model.addAttribute("property", entity);
		Selling selling = managementService.getSellingByProperty(id);
		model.addAttribute("selling", selling);
		return "portada/productpage";
	}
		
}