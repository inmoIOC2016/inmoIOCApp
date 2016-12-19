package com.inmoioc.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Objecte de domini de persistencia
 * @author: Sonia Carrillo Mañas
 */

@Entity
@Table(name="db_user")
public class User{
	
	@Id
	@Column(name="id_user")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_user;
	
	@Column(name="username")
	String username;
	
	@Column(name="password")
	String password;	
	
	@Column(name="email")
	String email;	
	
	@Column(name="rights")
	String rights;	
	
	@Column(name="registration_date")
	Date registration_date;
	
	public User() {
		super();
	}
	public User(int id_user, String username,String password, String email, String rights, Date registration_date) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password=password;
		this.email = email;
		this.rights=rights;
		this.registration_date=registration_date;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	public Date getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	
}