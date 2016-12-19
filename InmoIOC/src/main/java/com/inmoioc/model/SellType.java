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
@Table(name="db_selltype")
public class SellType{
	
	@Id
	@Column(name="id_type")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_type;
	
	@Column(name="name")
	String name;
	
	public SellType() {
		super();
	}
	public SellType(int id_type, String name) {
		super();
		this.id_type = id_type;
		this.name = name;		
	}
	public int getId_type() {
		return id_type;
	}
	public void setId_type(int id_type) {
		this.id_type = id_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}