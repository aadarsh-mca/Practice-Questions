package com.voting.service;

import java.sql.SQLException;

import com.voting.dao.UserDao;
import com.voting.dao.UserDaoImpl;
import com.voting.pojos.User;

public class UserBean {
//properties
	private String email;
	private String password;
	// dependency
	private UserDao userDao;
	// user details fetched from DB
	private User userDetails;
	//add string status | mesg - to store login status
	private String message;

	// def ctor to create the dao instance
	public UserBean() throws SQLException {
		userDao = new UserDaoImpl();
		System.out.println("user bean created !");
	}

	// generate setters n getters
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

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	

	public String getMessage() {
		return message;
	}

	// add business logic(service) method
	public String authenticate() throws SQLException {
		System.out.println("in B.L - auth user " + email + " " + password);
		// invoke dao's method here , using the dependency
		userDetails = userDao.authenticateUser(email, password);
		// check if valid or invalid
		if (userDetails == null) {
			message="Invalid email or password !!!!! , Please retry !";
			return "login";
		}
		message="Login successful !";
		// => authentication succeeds 
		//-> continue to role based authorization
		if (userDetails.getRole().equals("admin")) {
			return "admin";
		}
		if (userDetails.isStatus())
			return "logout";
		return "candidate_list";

	}

}
