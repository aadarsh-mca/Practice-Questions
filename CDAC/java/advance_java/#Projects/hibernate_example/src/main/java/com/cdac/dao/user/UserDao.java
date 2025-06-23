package com.cdac.dao.user;

import org.hibernate.HibernateException;

import com.cdac.entities.User;

public interface UserDao {
	
	String signUp(User newUser);
	
}
