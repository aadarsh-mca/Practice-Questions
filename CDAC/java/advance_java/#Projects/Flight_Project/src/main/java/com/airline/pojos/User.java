package com.airline.pojos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String mobile;
	private String address;
	private String email;
	private String password;
	
	public static User getUserWithoutPassword(ResultSet result) throws SQLException {
		return new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6));
	}
	
	public User(int id, String firstName, String lastName, String mobile, String address, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
	}

	public static User getUser(ResultSet result) throws SQLException {
		return new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
	}

	public User(int id, String firstName, String lastName, String mobile, String address, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [ id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", address = " + address
				+ ", mobile = " + mobile + ", email = " + email + ", password = " + password + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
}
