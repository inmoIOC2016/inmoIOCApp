package com.inmoioc.model;

import java.sql.Date;

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
@Table(name="db_selling")
public class Selling{
	
	@Id
	@Column(name="id_selling")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_selling;
	
	@ManyToOne
	@JoinColumn(name ="id_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name ="id_property")
	private Property property;
	
	@Column(name="expected_price")
	float expected_price;	
	
	@ManyToOne
	@JoinColumn(name ="sell_type")
	private SellType sellType;
	
	@Column(name="date_start")
	Date date_start;
	
	@Column(name="date_end")
	Date date_end;
	
	@ManyToOne
	@JoinColumn(name ="id_status")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name ="id_user_payment")
	private User userPayment;
	
	public Selling() {
		super();
	}
	public Selling(int id_selling, User user, Property property, float expected_price, SellType sellType, Date date_start, Date date_end, Status status, User userPayment) {
		super();
		this.id_selling = id_selling;
		this.user = user;
		this.property=property;
		this.expected_price = expected_price;
		this.sellType = sellType;
		this.date_start = date_start;
		this.date_end = date_end;
		this.status = status;
		this.userPayment = userPayment;
	}
	public int getId_selling() {
		return id_selling;
	}
	public void setId_selling(int id_selling) {
		this.id_selling = id_selling;
	}
	public float getExpected_price() {
		return expected_price;
	}
	public void setExpected_price(float expected_price) {
		this.expected_price = expected_price;
	}
	public Date getDate_start() {
		return date_start;
	}
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}
	public Date getDate_end() {
		return date_end;
	}
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public SellType getSellType() {
		return sellType;
	}
	public void setSellType(SellType sellType) {
		this.sellType = sellType;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public User getUserPayment() {
		return userPayment;
	}
	public void setUserPayment(User userPayment) {
		this.userPayment = userPayment;
	}
}