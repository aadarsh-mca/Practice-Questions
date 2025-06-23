package com.cdac.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;  // JPA
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;  // JPA
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

/**
 * Mandatory Annotation to manage entity lifecycle
 * 
 * @Entity - class level
 * @Id - field / getter level - for Primary Key (keep it reference type of easy null checking)
 *
 */

@Entity  // Mandatory
@Table(name = "users")
public class User {
	
	@Id  // Mandatory
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "first_name", length = 20)
	private String firstName;
	
	@Column(name = "last_name", length = 20)
	private String lastName;
	
	@Column(length = 50, unique = true)
	private String email;
	
	@Column(length = 32, nullable = false)
	private String password;
	
	private java.time.LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role")
	private UserRole role;
	
	@Lob  // long object
	private byte[] image;
	
	public User() {
		super();
	}
	
	public User(String firstName, String lastName, String email, String password, LocalDate dob, UserRole role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [ userId = " + userId + ", firstName = " + firstName + ", lastName = " + lastName + ", email = " + email
				+ ", password = " + password + ", dob = " + dob + ", role = " + role + " ]";
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public java.time.LocalDate getDob() {
		return dob;
	}

	public void setDob(java.time.LocalDate dob) {
		this.dob = dob;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
}
