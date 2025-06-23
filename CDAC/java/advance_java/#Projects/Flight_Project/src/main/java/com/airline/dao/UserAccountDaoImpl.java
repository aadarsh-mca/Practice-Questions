package com.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.airline.pojos.User;
import com.airline.utils.DBUtils;

public class UserAccountDaoImpl implements UserAccountDao {
	
	private Connection connection;
	private PreparedStatement getUserSt, loginUserSt, registerUserSt;
	
	private static UserAccountDaoImpl instance;
	
	public static UserAccountDaoImpl getInstance() throws SQLException {
		if(instance == null) {
			instance = new UserAccountDaoImpl();
		}
		return instance;
	}
	
	private UserAccountDaoImpl() throws SQLException {
		connection = DBUtils.getInstance().getConnection();
		
		getUserSt = connection.prepareStatement("Select id, first_name, last_name, mobile, address, email From Flight_Users Where id=?");
		
		loginUserSt = connection.prepareStatement("Select * From Flight_Users Where email=? AND password=?");
		
		// id, fN, lN, mb, add, em, pas
		registerUserSt = connection.prepareStatement("Insert into Flight_Users"
				+ "(first_name, last_name, mobile, address, email, password) "
				+ "Values (?, ?, ?, ?, ?, ?)");
		
		System.out.println("====== [ UserAccount DAO Created !!! ] ======");
	}
	
	@Override
	public User getUser(int userId) throws SQLException {
		getUserSt.setInt(1, userId);
		
		try(ResultSet result = loginUserSt.executeQuery()) {
			if(result.next()) {
				return User.getUserWithoutPassword(result);
			}
		}
		return null;
	}
	
	@Override
	public User login(String email, String password) throws SQLException {
		loginUserSt.setString(1, email);
		loginUserSt.setString(2, password);
		
		try(ResultSet result = loginUserSt.executeQuery()) {
			if(result.next()) {
				return User.getUser(result);
			}
		}
		return null;
	}

	@Override
	public User register(String firstName, String lastName, String mobile, String address, String email,
			String password) throws SQLException {
		
		registerUserSt.setString(1, firstName);
		registerUserSt.setString(2, lastName);
		registerUserSt.setString(3, mobile);
		registerUserSt.setString(4, address);
		registerUserSt.setString(5, email);
		registerUserSt.setString(6, password);

		if(registerUserSt.executeUpdate() == 1) {
			return login(email, password);
		}
		return null;
	}

	@Override
	public void cleanUp() throws SQLException {
		if(loginUserSt != null) loginUserSt.close();
		if(registerUserSt != null) registerUserSt.close();
	}

	
}
