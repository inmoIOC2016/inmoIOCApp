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
@Table(name="db_property")
public class Property{
	
	@Id
	@Column(name="id_property")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_property;
	
	@Column(name="name")
	String name;
	
	@Column(name="address")
	String address;	
	
	@Column(name="id_category")
	int id_category;	
	
	@Column(name="sell_type")
	int sell_type;	
	
	@Column(name="base_price")
	float base_price;
	
	@Column(name="contact")
	String contact;	
	
	@Column(name="available")
	int available;	
	
	public Property() {
		super();
	}
	public Property(int id_property, String name, String address, int id_category, int sell_type, float base_price, String contact, int available) {
		super();
		this.id_property = id_property;
		this.name = name;
		this.address=address;
		this.id_category = id_category;
		this.sell_type = sell_type;
		this.base_price = base_price;
		this.contact = contact;
		this.available = available;		
	}
	public int getId_property() {
		return id_property;
	}
	public void setId_property(int id_property) {
		this.id_property = id_property;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public int getSell_type() {
		return sell_type;
	}
	public void setSell_type(int sell_type) {
		this.sell_type = sell_type;
	}
	public float getBase_price() {
		return base_price;
	}
	public void setBase_price(float base_price) {
		this.base_price = base_price;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
}