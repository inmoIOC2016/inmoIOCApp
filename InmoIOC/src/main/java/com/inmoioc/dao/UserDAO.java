package com.inmoioc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inmoioc.model.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public User getUser(String username, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		String query = "SELECT u FROM User u WHERE u.username LIKE :username AND u.password LIKE :password";		
		List<User> list = session.createQuery(query).setParameter("username", username).setParameter("password", password).list();
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
