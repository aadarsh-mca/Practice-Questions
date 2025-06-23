package com.airline.dao;

import java.sql.SQLException;

import com.airline.pojos.User;

public interface UserAccountDao {

	User getUser(int userId) throws SQLException;
	User login(String email, String password) throws SQLException;
	User register(String firstName, String lastName, String mobile, String address, String email, String password) throws SQLException;

	void cleanUp() throws SQLException ;
}
