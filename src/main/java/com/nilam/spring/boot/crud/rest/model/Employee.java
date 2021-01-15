package com.nilam.spring.boot.crud.rest.model;

public class Employee {
	private int id;
	private String name;
	private String emailId;
	private float salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Employee() {
	}
	
	public Employee(int id, String name, String emailId, float salary) {
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.salary = salary;
	}
}
