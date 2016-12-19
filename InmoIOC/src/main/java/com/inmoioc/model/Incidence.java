package com.inmoioc.model;

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
@Table(name="db_incidence")
public class Incidence{
	
	@Id
	@Column(name="id_incidence")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_incidence;
	
	@Column(name="id_user")
	int id_user;
	
	@Column(name="title")
	String title;
	
	@Column(name="description")
	String description;
	
	public Incidence() {
		super();
	}
	public Incidence(int id_incidence, int id_user, String title, String description) {
		super();
		this.id_incidence = id_incidence;
		this.id_user = id_user;
		this.title = title;
		this.description = description;		
	}
	public int getId_incidence() {
		return id_incidence;
	}
	public void setId_incidence(int id_incidence) {
		this.id_incidence = id_incidence;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}