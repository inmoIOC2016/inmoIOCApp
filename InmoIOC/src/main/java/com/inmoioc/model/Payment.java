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
@Table(name="db_payments")
public class Payment{
	
	@Id
	@Column(name="id_payment")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_payment;
	
	@Column(name="id_selling")
	int id_selling;
	
	@Column(name="id_user")
	int id_user;	
	
	@Column(name="amount")
	float amount;	
	
	@Column(name="documentation")
	String documentation;	
	
	@Column(name="date_payment")
	Date date_payment;
	
	public Payment() {
		super();
	}
	public Payment(int id_payment, int id_selling, int id_user, float amount, String documentation, Date date_payment) {
		super();
		this.id_payment = id_payment;
		this.id_selling = id_selling;
		this.id_user=id_user;
		this.amount = amount;
		this.documentation = documentation;
		this.date_payment = date_payment;	
	}
	public int getId_payment() {
		return id_payment;
	}
	public void setId_payment(int id_payment) {
		this.id_payment = id_payment;
	}
	public int getId_selling() {
		return id_selling;
	}
	public void setId_selling(int id_selling) {
		this.id_selling = id_selling;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	public Date getDate_payment() {
		return date_payment;
	}
	public void setDate_payment(Date date_payment) {
		this.date_payment = date_payment;
	}
}