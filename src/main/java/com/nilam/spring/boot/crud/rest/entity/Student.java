package com.nilam.spring.boot.crud.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String city;
	
	public Student() {
		
	}
	
	public Student(Long id, String name, String email, String city) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.city =city;
	}
	
	public Student(String name, String email, String city) {
		this.name = name;
		this.email = email;
		this.city =city;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
