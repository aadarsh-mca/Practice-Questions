package com.app.beans;
//dependent - Java Bean

import java.time.LocalDate;
import java.time.Period;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBean {
//state - client's conversational state
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String dob;// Java bean dev. has to parse string -> Date
	// dependency - Dao layer
	private UserDaoImpl userDao;
	// user details - under session scope(simply add it as the property of a java
	// bean)
	private User userDetails;
	// add a property for status message
	private String message;

	// def ctor
	public UserBean() {
		// create depcy (dependency)
		userDao = new UserDaoImpl();
		System.out.println("user bean created");
	}

	// Business logic method for user authentication
	public String authenticateUser() {
		System.out.println("in auth user " + email + " " + password);
		try {
			// invoke dao's method
			userDetails = userDao.signIn(email, password);
		} catch (RuntimeException e) {
			// => invalid login
			message = "Invalid email or password , Please retry !!!!";
			return "login";// JB rets -> JSP -> dynamic navigational outcome !
		}

		// => valid login
		message = "Login Successful!";
		if (userDetails.getRole().equals("admin")) {
			return "admin_page";
		}
		// => voter
		if (userDetails.isStatus())
			return "logout";
		// => not yet voted
		return "candidate_list";

	}

	// add B.L method for validation n registration of voter
	public String validateAndRegisterVoter() {
		System.out.println("in reg " + firstName + " " + dob);
		// validate age
		LocalDate dateOfBirth = LocalDate.parse(dob);
		int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
		if (age > 21) {
			// create voter instance : transient(not yet persistent!)
			User voter = new User(firstName, lastName, email, password, dateOfBirth);
			// invoke dao's method
			return userDao.voterRegistration(voter);
		} else
			return "Voter registration failed - Invalid Age !!!";
	}

}
