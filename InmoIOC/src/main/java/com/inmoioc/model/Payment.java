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
@Table(name="db_payments")
public class Payment{
	
	@Id
	@Column(name="id_payment")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_payment;
	
	@ManyToOne
	@JoinColumn(name ="id_selling")
	private Selling selling;
	
	@Column(name="amount")
	float amount;	
	
	@Column(name="date_payment")
	Date date_payment;
	
	public Payment() {
		super();
	}
	public Payment(int id_payment, Selling selling, float amount, Date date_payment) {
		super();
		this.id_payment = id_payment;
		this.selling = selling;
		this.amount = amount;
		this.date_payment = date_payment;	
	}
	public int getId_payment() {
		return id_payment;
	}
	public void setId_payment(int id_payment) {
		this.id_payment = id_payment;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getDate_payment() {
		return date_payment;
	}
	public void setDate_payment(Date date_payment) {
		this.date_payment = date_payment;
	}
	public Selling getSelling() {
		return selling;
	}
	public void setSelling(Selling selling) {
		this.selling = selling;
	}
}