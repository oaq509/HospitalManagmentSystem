package com.kau.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // use this annotation to declare your class as entitiy class
@Table(name = "doctors") // creating doctor table
public class Doctor {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // rule
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phone_number;

	@Column(name = "major")
	private String major;

	public Doctor() {

	}

	public Doctor(String firstName, String lastName, String email, String phone_number, String major) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone_number = phone_number;
		this.major = major;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}
