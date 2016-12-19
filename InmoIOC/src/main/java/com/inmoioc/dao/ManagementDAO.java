package com.inmoioc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inmoioc.model.Category;
import com.inmoioc.model.Incidence;
import com.inmoioc.model.Payment;
import com.inmoioc.model.Property;
import com.inmoioc.model.SellType;
import com.inmoioc.model.Selling;
import com.inmoioc.model.User;

/**
 * Access a la base de dades 
 * @author: Sonia Carrillo Mañas
 */

@Repository
public class ManagementDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	// CATEGORY
	
	public List<Category> getAllCategory() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> list = session.createQuery("from Category").list();
		return list;
	}

	public Category getCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category obj = (Category) session.get(Category.class, new Integer(id));
		return obj;
	}

	public Category addCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(category);
		return category;
	}

	public void updateCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(category);
	}

	public void deleteCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category obj = (Category) session.load(Category.class, new Integer(id));
		if (null != obj) {
			session.delete(obj);
		}
	}
	
	// INCIDENCE
		
	public List<Incidence> getAllIncidence() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Incidence> list = session.createQuery("from Incidence").list();
		return list;
	}
	
	public Incidence getIncidence(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Incidence obj = (Incidence) session.get(Incidence.class, new Integer(id));
		return obj;
	}
	
	public Incidence addIncidence(Incidence incidence) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(incidence);
		return incidence;
	}

	public void updateIncidence(Incidence incidence) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(incidence);
	}
	
	public void deleteIncidence(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Incidence obj = (Incidence) session.load(Incidence.class, new Integer(id));
		if (null != obj) {
			session.delete(obj);
		}
	}
	
	// PAYMENT	
	
	public List<Payment> getAllPayment() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Payment> list = session.createQuery("from Payment").list();
		return list;
	}

	public Payment getPayment(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Payment obj = (Payment) session.get(Payment.class, new Integer(id));
		return obj;
	}

	public Payment addPayment(Payment payment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(payment);
		return payment;
	}

	public void updatePayment(Payment payment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(payment);
	}

	public void deletePayment(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Payment obj = (Payment) session.load(Payment.class, new Integer(id));
		if (null != obj) {
			session.delete(obj);
		}
	}
	
	// PROPERTY
	
	public List<Property> getAllProperty() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Property> list = session.createQuery("from Property").list();
		return list;
	}

	public Property getProperty(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Property obj = (Property) session.get(Property.class, new Integer(id));
		return obj;
	}

	public Property addProperty(Property property) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(property);
		return property;
	}

	public void updateProperty(Property property) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(property);
	}

	public void deleteProperty(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Property obj = (Property) session.load(Property.class, new Integer(id));
		if (null != obj) {
			session.delete(obj);
		}
	}
	
	// SELLING
		
	public List<Selling> getAllSelling() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Selling> list = session.createQuery("from Selling").list();
		return list;
	}

	public Selling getSelling(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Selling obj = (Selling) session.get(Selling.class, new Integer(id));
		return obj;
	}

	public Selling addSelling(Selling selling) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(selling);
		return selling;
	}

	public void updateSelling(Selling selling) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(selling);
	}

	public void deleteSelling(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Selling obj = (Selling) session.load(Selling.class, new Integer(id));
		if (null != obj) {
			session.delete(obj);
		}
	}

	// SELLTYPE
	
	public List<SellType> getAllSellType() {
		Session session = this.sessionFactory.getCurrentSession();
		List<SellType> list = session.createQuery("from SellType").list();
		return list;
	}

	public SellType getSellType(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SellType obj = (SellType) session.get(SellType.class, new Integer(id));
		return obj;
	}

	public SellType addSellType(SellType sellType) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sellType);
		return sellType;
	}

	public void updateSellType(SellType sellType) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(sellType);
	}

	public void deleteSellType(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SellType obj = (SellType) session.load(SellType.class, new Integer(id));
		if (null != obj) {
			session.delete(obj);
		}
	}
	
	// USER
	
	public List<User> getAllUser() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> list = session.createQuery("from User").list();
		return list;
	}

	public User getUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User obj = (User) session.get(User.class, new Integer(id));
		return obj;
	}

	public User addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		return user;
	}

	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
	}

	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User obj = (User) session.load(User.class, new Integer(id));
		if (null != obj) {
			session.delete(obj);
		}
	}

}
