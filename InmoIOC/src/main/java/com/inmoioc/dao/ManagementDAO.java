package com.inmoioc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

/**
 * Access a la base de dades 
 * @author: Sonia Carrillo Mañas - Iván Soto Román - Albert Conesa Garcia
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
	
	public Incidence getIncidenceById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Incidence obj = (Incidence) session.get(Incidence.class, new Integer(id));
		return obj;
	}
		
	public List<Incidence> getIncidenceByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Incidence I WHERE I.description like :description";				
		Query query = session.createQuery(hql);		
		query.setParameter("description", "%" + name + "%");
		List<Incidence> list = query.list();		
		return list;
	}
	
	public List<Incidence> getIncidenceByIdUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Incidence I WHERE I.user.id_user like :id_user";
		Query query = session.createQuery(hql);		
		query.setParameter("id_user", id);
		List<Incidence> list = query.list();		
		return list;
	}
	
	public List<Incidence> getIncidence(int id, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "";
		int opc = 0;
		if(Integer.valueOf(id)!=null && name!=null && !name.isEmpty()){
			opc = 1;
			hql = "from Incidence I WHERE I.id_incidence = :id_incidence AND I.description like :description";
		} else if(Integer.valueOf(id)!=null){
			opc = 2;
			hql = "from Incidence I WHERE I.id_incidence = :id_incidence";
		} else if(name!=null && !name.isEmpty()){
			opc = 3;
			hql = "from Incidence I WHERE I.description like :description";
		}		
		Query query = session.createQuery(hql);
		if(opc == 1 || opc == 2) query.setParameter("id_incidence", id);
		if(opc == 1 || opc == 3) query.setParameter("description", "%" + name + "%");
		List<Incidence> list = new ArrayList();
		if(opc > 0) list = query.list();
		return list;
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
	
	public Payment getPaymentById(int id) {
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
	
	public List<Property> getPropertyWebsite(int state) {
		Session session = this.sessionFactory.getCurrentSession();
		//List<Property> list = session.createQuery("from Property").list();
		List<Property> list = session.createQuery("from Property P WHERE P.available = 1 AND P.id_property IN (SELECT S.property FROM Selling S WHERE S.status = " + state + ")").list();
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
	
	public List<Property> getPropertyByIdUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Property P WHERE P.user.id_user = :id_user";
		Query query = session.createQuery(hql);		
		query.setParameter("id_user", id);
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
	
	public List<Selling> getSellingByIdUser(int id, boolean state) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "";
		if(state){
			hql = "from Selling S WHERE S.user.id_user in (:id_user)";
		} else {
			hql = "from Selling S WHERE S.user.id_user not in (:id_user)";
		}
		Query query = session.createQuery(hql);		
		query.setParameter("id_user", id);
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
	
	public List<User> getUser(Integer id, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "";
		int opc = 0;
		if(id!=null && name!=null && !name.isEmpty()){
			opc = 1;
			hql = "from User U WHERE U.id_user = :id_user AND U.username like :username";
		} else if(id!=null){
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

	// ROLE
	
	public List<Role> getAllRoles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Role> list = session.createQuery("from Role").list();
		return list;
	}

	public Role getRoleById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Role obj = (Role) session.get(Role.class, new Integer(id));
		return obj;
	}		
		
	public List<Role> getRoleByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Role R WHERE R.role like :rolename";				
		Query query = session.createQuery(hql);		
		query.setParameter("rolename", "%" + name + "%");
		List<Role> list = query.list();		
		return list;
	}
	
	public List<Role> getRole(int id, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "";
		int opc = 0;
		if(Integer.valueOf(id)!=null && name!=null && !name.isEmpty()){
			opc = 1;
			hql = "from Role R WHERE R.id_role = :id_role AND R.role like :role";
		} else if(Integer.valueOf(id)!=null){
			opc = 2;
			hql = "from Role R WHERE R.id_role = :id_role";
		} else if(name!=null && !name.isEmpty()){
			opc = 3;
			hql = "from Role R WHERE R.role like :role";
		}		
		Query query = session.createQuery(hql);
		if(opc == 1 || opc == 2) query.setParameter("id_role", id);
		if(opc == 1 || opc == 3) query.setParameter("role", "%" + name + "%");
		List<Role> list = new ArrayList();
		if(opc > 0) list = query.list();
		return list;
	}

	public Role addRole(Role role) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(role);
		return role;
	}

	public void updateRole(Role role) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(role);
	}

	public void deleteRole(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Role obj = (Role) session.load(Role.class, new Integer(id));
		if (null != obj) {
			session.delete(obj);
		}
	}

	// CITY
	
	public List<City> getAllCities() {
		Session session = this.sessionFactory.getCurrentSession();
		List<City> list = session.createQuery("from City").list();
		return list;
	}

	public City getCityById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		City obj = (City) session.get(City.class, new Integer(id));
		return obj;
	}		
		
	public List<City> getCityByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from City C WHERE C.city like :cityname";				
		Query query = session.createQuery(hql);		
		query.setParameter("cityname", "%" + name + "%");
		List<City> list = query.list();		
		return list;
	}
	
	public List<City> getCity(int id, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "";
		int opc = 0;
		if(Integer.valueOf(id)!=null && name!=null && !name.isEmpty()){
			opc = 1;
			hql = "from City C WHERE C.id_city = :id_city AND C.city like :role";
		} else if(Integer.valueOf(id)!=null){
			opc = 2;
			hql = "from City C WHERE C.id_city = :id_city";
		} else if(name!=null && !name.isEmpty()){
			opc = 3;
			hql = "from City C WHERE C.city like :city";
		}		
		Query query = session.createQuery(hql);
		if(opc == 1 || opc == 2) query.setParameter("id_city", id);
		if(opc == 1 || opc == 3) query.setParameter("city", "%" + name + "%");
		List<City> list = new ArrayList();
		if(opc > 0) list = query.list();
		return list;
	}

	public City addCity(City city) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(city);
		return city;
	}

	public void updateCity(City city) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(city);
	}

	public void deleteCity(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		City obj = (City) session.load(City.class, new Integer(id));
		if (null != obj) {
			session.delete(obj);
		}
	}

	// STATUS
	
	public List<Status> getAllStatus() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Status> list = session.createQuery("from Status").list();
		return list;
	}

	public Status getStatusById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Status obj = (Status) session.get(Status.class, new Integer(id));
		return obj;
	}		
		
	public List<Status> getStatusByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Status S WHERE S.status like :status";				
		Query query = session.createQuery(hql);		
		query.setParameter("status", "%" + name + "%");
		List<Status> list = query.list();		
		return list;
	}
	
	public List<Status> getStatus(int id, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "";
		int opc = 0;
		if(Integer.valueOf(id)!=null && name!=null && !name.isEmpty()){
			opc = 1;
			hql = "from Status S WHERE S.id_status = :id_status AND S.status like :status";
		} else if(Integer.valueOf(id)!=null){
			opc = 2;
			hql = "from Status S WHERE S.id_status = :id_status";
		} else if(name!=null && !name.isEmpty()){
			opc = 3;
			hql = "from Status S WHERE S.status like :status";
		}		
		Query query = session.createQuery(hql);
		if(opc == 1 || opc == 2) query.setParameter("id_status", id);
		if(opc == 1 || opc == 3) query.setParameter("status", "%" + name + "%");
		List<Status> list = new ArrayList();
		if(opc > 0) list = query.list();
		return list;
	}

	public Status addStatus(Status status) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(status);
		return status;
	}

	public void updateStatus(Status status) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(status);
	}

	public void deleteStatus(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Status obj = (Status) session.load(Status.class, new Integer(id));
		if (null != obj) {
			session.delete(obj);
		}
	}
	
	// INCIDENCE STATUS
	
	public List<IncidenceStatus> getAllIncidenceStatus() {
		Session session = this.sessionFactory.getCurrentSession();
		List<IncidenceStatus> list = session.createQuery("from IncidenceStatus").list();
		return list;
	}

	public IncidenceStatus getIncidenceStatusById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		IncidenceStatus obj = (IncidenceStatus) session.get(IncidenceStatus.class, new Integer(id));
		return obj;
	}		
		
	public List<IncidenceStatus> getIncidenceStatusByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from IncidenceStatus S WHERE S.status like :status";				
		Query query = session.createQuery(hql);		
		query.setParameter("status", "%" + name + "%");
		List<IncidenceStatus> list = query.list();		
		return list;
	}
	
	public List<IncidenceStatus> getIncidenceStatus(int id, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "";
		int opc = 0;
		if(Integer.valueOf(id)!=null && name!=null && !name.isEmpty()){
			opc = 1;
			hql = "from IncidenceStatus S WHERE S.id_status = :id_status AND S.status like :status";
		} else if(Integer.valueOf(id)!=null){
			opc = 2;
			hql = "from IncidenceStatus S WHERE S.id_status = :id_status";
		} else if(name!=null && !name.isEmpty()){
			opc = 3;
			hql = "from IncidenceStatus S WHERE S.status like :status";
		}		
		Query query = session.createQuery(hql);
		if(opc == 1 || opc == 2) query.setParameter("id_status", id);
		if(opc == 1 || opc == 3) query.setParameter("status", "%" + name + "%");
		List<IncidenceStatus> list = new ArrayList();
		if(opc > 0) list = query.list();
		return list;
	}

	public IncidenceStatus addIncidenceStatus(IncidenceStatus incidenceStatus) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(incidenceStatus);
		return incidenceStatus;
	}

	public void updateIncidenceStatus(IncidenceStatus incidenceStatus) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(incidenceStatus);
	}

	public void deleteIncidenceStatus(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		IncidenceStatus obj = (IncidenceStatus) session.load(IncidenceStatus.class, new Integer(id));
		if (null != obj) {
			session.delete(obj);
		}
	}
	
	
}
