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
@Table(name="db_cities")
public class City{
	
	@Id
	@Column(name="id_city")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_city;
	
	@Column(name="city")
	String city;
	
	public City() {
		super();
	}
	public City(int id_city, String city) {
		super();
		this.id_city = id_city;
		this.city = city;		
	}
	public int getId_city() {
		return id_city;
	}
	public void setId_city(int id_city) {
		this.id_city = id_city;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}