package com.voting.service;

import java.sql.SQLException;

import com.voting.dao.UserDao;
import com.voting.dao.UserDaoImpl;
import com.voting.pojos.User;

/**
 * 
 * A Java Bean class
 * 
 */
public class UserBean {
	private String email;
	private String password;
	private User userDetail;

	private UserDao userDao;
	
	private String message;
	
	public UserBean() throws SQLException {
		this.userDao = new UserDaoImpl();
	}
	
	public String authenticate() throws SQLException {
		System.out.println("====== [ UserBean Authentication ] ======");
		
		userDetail = userDao.authenticateUser(email, password);
		
		if(userDetail == null) {
			message = "Invalid Email/Password !!!, Please retry....";
			return "login";
		}
		
		if(userDetail != null) {
			message = "Success login !!!";
			
			if(userDetail.getRole().equals("admin")) {
				return "admin";
			} else {
				// voter
				if(userDetail.isStatus()) {
					return "logout";
				} else {
					return "candidate_list";
				}
			}
		}
		
		return "";
	}
	
	@Override
	public String toString() {
		return "UserBean [email=" + email + ", password=" + password + ", userDetails=" + userDetail + ", userDao="
				+ userDao + "]";
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

	public User getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(User userDetails) {
		this.userDetail = userDetails;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
