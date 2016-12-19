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
@Table(name="db_category")
public class Category{
	
	@Id
	@Column(name="id_category")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_category;
	
	@Column(name="name")
	String name;
	
	public Category() {
		super();
	}
	public Category(int id_category, String name) {
		super();
		this.id_category = id_category;
		this.name = name;		
	}
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}