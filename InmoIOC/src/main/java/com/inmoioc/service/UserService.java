package com.inmoioc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmoioc.dao.UserDAO;
import com.inmoioc.model.User;

/**
 * Capa de servei per fer us de la persistencia a base de dades
 * @author: Sonia Carrillo Mañas - Iván Soto Román - Albert Conesa Garcia
 */

@Service("userService")
public class UserService {

	@Autowired
	UserDAO userDao;
	
	@Transactional
	public User getUser(String username, String password) {
		return userDao.getUser(username, password);
	}
	
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}
