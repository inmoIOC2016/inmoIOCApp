package com.inmoioc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmoioc.dao.ManagementDAO;
import com.inmoioc.model.Category;
import com.inmoioc.model.Incidence;
import com.inmoioc.model.Payment;
import com.inmoioc.model.Property;
import com.inmoioc.model.SellType;
import com.inmoioc.model.Selling;
import com.inmoioc.model.User;

/**
 * Capa de servei per fer us de la persistencia a base de dades
 * @author: Sonia Carrillo Mañas
 */

@Service("managementService")
public class ManagementService {

	@Autowired
	ManagementDAO managementDAO;
	
	// CATEGORY
	
	@Transactional
	public List<Category> getAllCategory() {
		return managementDAO.getAllCategory();
	}

	@Transactional
	public Category getCategoryById(int id) {
		return managementDAO.getCategoryById(id);
	}
	
	@Transactional
	public List<Category> getCategoryByName(String name) {
		return managementDAO.getCategoryByName(name);
	}
	
	@Transactional
	public List<Category> getCategory(int id, String name) {
		return managementDAO.getCategory(id, name);
	}

	@Transactional
	public void addCategory(Category category) {
		managementDAO.addCategory(category);
	}

	@Transactional
	public void updateCategory(Category category) {
		managementDAO.updateCategory(category);
	}

	@Transactional
	public void deleteCategory(int id) {
		managementDAO.deleteCategory(id);
	}
	
	// INCIDENCE
	
	@Transactional
	public List<Incidence> getAllIncidence() {
		return managementDAO.getAllIncidence();
	}

	@Transactional
	public Incidence getIncidence(int id) {
		return managementDAO.getIncidence(id);
	}

	@Transactional
	public void addIncidence(Incidence incidence) {
		managementDAO.addIncidence(incidence);
	}

	@Transactional
	public void updateIncidence(Incidence incidence) {
		managementDAO.updateIncidence(incidence);
	}

	@Transactional
	public void deleteIncidence(int id) {
		managementDAO.deleteIncidence(id);
	}
	
	// PAYMENT
	
	@Transactional
	public List<Payment> getAllPayment() {
		return managementDAO.getAllPayment();
	}

	@Transactional
	public Payment getPayment(int id) {
		return managementDAO.getPayment(id);
	}

	@Transactional
	public void addPayment(Payment payment) {
		managementDAO.addPayment(payment);
	}

	@Transactional
	public void updatePayment(Payment payment) {
		managementDAO.updatePayment(payment);
	}

	@Transactional
	public void deletePayment(int id) {
		managementDAO.deletePayment(id);
	}
	
	// PROPERTY
	
	@Transactional
	public List<Property> getAllProperty() {
		return managementDAO.getAllProperty();
	}	
	
	@Transactional
	public Property getPropertyById(int id) {
		return managementDAO.getPropertyById(id);
	}
	
	@Transactional
	public List<Property> getPropertyByName(String name) {
		return managementDAO.getPropertyByName(name);
	}
	
	@Transactional
	public List<Property> getProperty(int id, String name) {
		return managementDAO.getProperty(id, name);
	}

	@Transactional
	public void addProperty(Property property) {
		managementDAO.addProperty(property);
	}

	@Transactional
	public void updateProperty(Property property) {
		managementDAO.updateProperty(property);
	}

	@Transactional
	public void deleteProperty(int id) {
		managementDAO.deleteProperty(id);
	}
	

	// SELLING
	
	@Transactional
	public List<Selling> getAllSelling() {
		return managementDAO.getAllSelling();
	}

	@Transactional
	public Selling getSellingById(int id) {
		return managementDAO.getSellingById(id);
	}
	
	@Transactional
	public List<Selling> getSellingByName(String name) {
		return managementDAO.getSellingByName(name);
	}
	
	@Transactional
	public List<Selling> getSelling(int id, int idProperty) {
		return managementDAO.getSelling(id, idProperty);
	}

	@Transactional
	public void addSelling(Selling selling) {
		managementDAO.addSelling(selling);
	}

	@Transactional
	public void updateSelling(Selling selling) {
		managementDAO.updateSelling(selling);
	}

	@Transactional
	public void deleteSelling(int id) {
		managementDAO.deleteSelling(id);
	}

	// SELLTYPE
	
	@Transactional
	public List<SellType> getAllSellType() {
		return managementDAO.getAllSellType();
	}

	@Transactional
	public SellType getSellType(int id) {
		return managementDAO.getSellType(id);
	}

	@Transactional
	public void addSellType(SellType sellType) {
		managementDAO.addSellType(sellType);
	}

	@Transactional
	public void updateSellType(SellType sellType) {
		managementDAO.updateSellType(sellType);
	}

	@Transactional
	public void deleteSellType(int id) {
		managementDAO.deleteSellType(id);
	}
	
	// USER
	
	@Transactional
	public List<User> getAllUser() {
		return managementDAO.getAllUser();
	}

	@Transactional
	public User getUserById(int id) {
		return managementDAO.getUserById(id);
	}
	
	@Transactional
	public List<User> getUserByName(String name) {
		return managementDAO.getUserByName(name);
	}
	
	@Transactional
	public List<User> getUser(int id, String name) {
		return managementDAO.getUser(id, name);
	}

	@Transactional
	public void addUser(User user) {
		managementDAO.addUser(user);
	}
	
	@Transactional
	public List<User> getUserByUserNameAndEmail(String userName, String email) {
		return managementDAO.getUserByUserNameAndEmail(userName, email);
	}

	@Transactional
	public void updateUser(User user) {
		managementDAO.updateUser(user);
	}

	@Transactional
	public void deleteUser(int id) {
		managementDAO.deleteUser(id);
	}

}
