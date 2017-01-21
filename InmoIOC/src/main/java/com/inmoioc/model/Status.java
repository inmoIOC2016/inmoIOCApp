package com.inmoioc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Objecte de domini de persistencia
 * @author: Sonia Carrillo Mañas - Iván Soto Román - Albert Conesa Garcia
 */

@Entity
@Table(name="db_status")
public class Status{
	
	@Id
	@Column(name="id_status")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_status;
	
	@Column(name="status")
	String status;
	
	public Status() {
		super();
	}
	public Status(int id_status, String status) {
		super();
		this.id_status = id_status;
		this.status = status;		
	}
	public int getId_status() {
		return id_status;
	}
	public void setId_status(int id_status) {
		this.id_status = id_status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}