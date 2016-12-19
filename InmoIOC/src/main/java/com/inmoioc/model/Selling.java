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
@Table(name="db_selling")
public class Selling{
	
	@Id
	@Column(name="id_selling")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_selling;
	
	@Column(name="id_user")
	int id_user;
	
	@Column(name="id_property")
	int id_property;	
	
	@Column(name="expected_price")
	float expected_price;	
	
	@Column(name="sell_type")
	int sell_type;	
	
	@Column(name="date_start")
	Date date_start;
	
	@Column(name="date_end")
	Date date_end;
	
	public Selling() {
		super();
	}
	public Selling(int id_selling, int id_user, int id_property, float expected_price, int sell_type, Date date_start, Date date_end) {
		super();
		this.id_selling = id_selling;
		this.id_user = id_user;
		this.id_property=id_property;
		this.expected_price = expected_price;
		this.sell_type = sell_type;
		this.date_start = date_start;
		this.date_end = date_end;	
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
	public int getId_property() {
		return id_property;
	}
	public void setId_property(int id_property) {
		this.id_property = id_property;
	}
	public float getExpected_price() {
		return expected_price;
	}
	public void setExpected_price(float expected_price) {
		this.expected_price = expected_price;
	}
	public int getSell_type() {
		return sell_type;
	}
	public void setSell_type(int sell_type) {
		this.sell_type = sell_type;
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
}