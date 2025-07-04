package com.voting.pojos;
/*
 * id | first_name | last_name | email            
 *  | password | dob        | status | role 
 */

import java.sql.Date;//sub class of java.util.Date

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date dob;
	private boolean status;
	private String role;
	//POJO - def ctor , getters n setters per field ,
	//toString - debugging
	public User() {
		// TODO Auto-generated constructor stub
	}
	//add oveloaded ctor	
	public User(int userId, String firstName, String lastName, String email, String password, Date dob, boolean status,
			String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.status = status;
		this.role = role;
	}
	//add overloaded ctor for user registration
	public User(String firstName, String lastName, 
			String email, String password, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", status=" + status + ", role=" + role + "]";
	}
	
	
	

}
