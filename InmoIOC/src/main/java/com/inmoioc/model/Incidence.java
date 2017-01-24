package com.inmoioc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Objecte de domini de persistencia
 * @author: Sonia Carrillo Mañas - Iván Soto Román - Albert Conesa Garcia
 */

@Entity
@Table(name="db_incidence")
public class Incidence{
	
	@Id
	@Column(name="id_incidence")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_incidence;
	
	@ManyToOne
	@JoinColumn(name ="id_user")
	private User user;
	
	@Column(name="description")
	String description;
	
	@ManyToOne
	@JoinColumn(name ="id_status")
	private IncidenceStatus status;
	
	@Column(name="file")
	private byte[] file;
	
	public Incidence() {
		super();
	}
	public Incidence(int id_incidence, User user, String description, IncidenceStatus status) {
		super();
		this.id_incidence = id_incidence;
		this.user = user;
		this.description = description;
		this.status = status;
	}
	public int getId_incidence() {
		return id_incidence;
	}
	public void setId_incidence(int id_incidence) {
		this.id_incidence = id_incidence;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public IncidenceStatus getStatus() {
		return status;
	}
	public void setStatus(IncidenceStatus status) {
		this.status = status;
	}
	public  byte[] getFile() {
		return file;
	}
	public void setFile(byte[] bytes) {
		this.file = file;
	}
}