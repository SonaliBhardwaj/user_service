package com.microservices.user.user_service.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;

	//When we dont use @Column it takes same name as field
	private String phone;
	
	@Transient
	private List<Contact> contacts = new ArrayList<Contact>();
	
	public User() {
		super();
	}

	public User(Long userId, String name, String phone, List<Contact> contacts) {
		super();
		this.id = userId;
		this.firstName = name;
		this.phone = phone;
		this.contacts = contacts;
	}

	public User(Long userId, String name, String phone) {
		super();
		this.id = userId;
		this.firstName = name;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long userId) {
		this.id = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}
