package com.inmoioc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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

	public Category getCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category obj = (Category) session.get(Category.class, new Integer(id));
		return obj;
	}
	
	public List<Category> getCategoryByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Category C WHERE C.name like :name";				
		Query query = session.createQuery(hql);		
		query.setParameter("name", "%" + name + "%");
		List<Category> list = query.list();		
		return list;
	}
	
	public List<Category> getCategory(int id, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "";
		int opc = 0;
		if(Integer.valueOf(id)!=null && name!=null && !name.isEmpty()){
			opc = 1;
			hql = "from Category C WHERE C.id_category = :id_category AND C.name like :name";
		} else if(Integer.valueOf(id)!=null){
			opc = 2;
			hql = "from Category C WHERE C.id_category = :id_category";
		} else if(name!=null && !name.isEmpty()){
			opc = 3;
			hql = "from Category C WHERE C.name like :name";
		}		
		Query query = session.createQuery(hql);
		if(opc == 1 || opc == 2) query.setParameter("id_category", id);
		if(opc == 1 || opc == 3) query.setParameter("name", "%" + name + "%");
		List<Category> list = new ArrayList();
		if(opc > 0) list = query.list();
		return list;
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

	public Property getPropertyById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Property obj = (Property) session.get(Property.class, new Integer(id));
		return obj;
	}
		
	public List<Property> getPropertyByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Property P WHERE P.name like :name";				
		Query query = session.createQuery(hql);		
		query.setParameter("name", "%" + name + "%");
		List<Property> list = query.list();		
		return list;
	}
	
	public List<Property> getProperty(int id, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "";
		int opc = 0;
		if(Integer.valueOf(id)!=null && name!=null && !name.isEmpty()){
			opc = 1;
			hql = "from Property P WHERE P.id_property = :id_property AND P.name like :name";
		} else if(Integer.valueOf(id)!=null){
			opc = 2;
			hql = "from Property P WHERE P.id_property = :id_property";
		} else if(name!=null && !name.isEmpty()){
			opc = 3;
			hql = "from Property P WHERE P.name like :name";
		}		
		Query query = session.createQuery(hql);
		if(opc == 1 || opc == 2) query.setParameter("id_property", id);
		if(opc == 1 || opc == 3) query.setParameter("name", "%" + name + "%");
		List<Property> list = new ArrayList();
		if(opc > 0) list = query.list();
		return list;
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

	public Selling getSellingById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Selling obj = (Selling) session.get(Selling.class, new Integer(id));
		return obj;
	}	
		
	public List<Selling> getSellingByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Selling S WHERE S.name like :name";				
		Query query = session.createQuery(hql);		
		query.setParameter("name", "%" + name + "%");
		List<Selling> list = query.list();		
		return list;
	}
	
	public List<Selling> getSelling(int id, int idProperty) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "";
		int opc = 0;
		if(Integer.valueOf(id)!=null && Integer.valueOf(idProperty)!=null){
			opc = 1;
			hql = "from Selling S WHERE S.id_selling = :id_selling AND S.id_property = :id_property";
		} else if(Integer.valueOf(id)!=null){
			opc = 2;
			hql = "from Selling S WHERE S.id_selling = :id_selling";
		} else if(Integer.valueOf(idProperty)!=null){
			opc = 3;
			hql = "from Selling S WHERE S.id_property = :id_property";
		}		
		Query query = session.createQuery(hql);
		if(opc == 1 || opc == 2) query.setParameter("id_selling", id);
		if(opc == 1 || opc == 3) query.setParameter("id_property", idProperty);
		List<Selling> list = new ArrayList();
		if(opc > 0) list = query.list();
		return list;
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

	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User obj = (User) session.get(User.class, new Integer(id));
		return obj;
	}		
		
	public List<User> getUserByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from User U WHERE U.username like :username";				
		Query query = session.createQuery(hql);		
		query.setParameter("username", "%" + name + "%");
		List<User> list = query.list();		
		return list;
	}
	
	public List<User> getUser(int id, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "";
		int opc = 0;
		if(Integer.valueOf(id)!=null && name!=null && !name.isEmpty()){
			opc = 1;
			hql = "from User U WHERE U.id_user = :id_user AND U.username like :username";
		} else if(Integer.valueOf(id)!=null){
			opc = 2;
			hql = "from User U WHERE U.id_user = :id_user";
		} else if(name!=null && !name.isEmpty()){
			opc = 3;
			hql = "from User U WHERE U.username like :username";
		}		
		Query query = session.createQuery(hql);
		if(opc == 1 || opc == 2) query.setParameter("id_user", id);
		if(opc == 1 || opc == 3) query.setParameter("username", "%" + name + "%");
		List<User> list = new ArrayList();
		if(opc > 0) list = query.list();
		return list;
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
	
	public List<User> getUserByUserNameAndEmail(String userName, String email) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from User U WHERE U.username like :userName OR U.email like :email";		
		Query query = session.createQuery(hql);
		query.setParameter("userName", userName);
		query.setParameter("email", email);
		List<User> list = query.list();
		return list;
	}

}
