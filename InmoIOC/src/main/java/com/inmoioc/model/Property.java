package com.inmoioc.model;

import java.util.Base64;

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
	
	@ManyToOne
	@JoinColumn(name ="id_category")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name ="sell_type")
	private SellType sellType;
	
	@Column(name="base_price")
	float base_price;
	
	@Column(name="contact")
	String contact;	
	
	@Column(name="available")
	Integer available;
	
	@ManyToOne
	@JoinColumn(name ="id_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name ="id_city")
	private City city;
	
	@Column(name="reg_selling")
	Integer reg_selling;
	
	@Column(name="image")
	private byte[] image;
	
	
	public Property() {
		super();
	}
	public Property(int id_property, String name, String address, Category category, SellType sellType, float base_price, String contact, Integer available, User user, City city, Integer reg_selling, byte[] image) {
		super();
		this.id_property = id_property;
		this.name = name;
		this.address=address;
		this.category = category;
		this.sellType = sellType;
		this.base_price = base_price;
		this.contact = contact;
		this.available = available;
		this.user = user;
		this.city = city;
		this.reg_selling = reg_selling;
		this.image = image;
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
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public SellType getSellType() {
		return sellType;
	}
	public void setSellType(SellType sellType) {
		this.sellType = sellType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Integer getReg_selling() {
		return reg_selling;
	}
	public void setReg_selling(Integer reg_selling) {
		this.reg_selling = reg_selling;
	}	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}	
	public String getbase64() {
		if (this.image != null)
		{
		  byte[] encoded=Base64.getEncoder().encode(this.image);
		  return new String(encoded);
		}
		else return "";
	}
	
}