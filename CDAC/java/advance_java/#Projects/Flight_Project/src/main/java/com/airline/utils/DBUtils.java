package com.airline.utils;

import java.sql.*;

public class DBUtils {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/iacsd_adv_java";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "Arsh007$";
	
	private Connection connection;
	
	/**
	 * Singleton Structure
	 */
	private static DBUtils instance;
	
	private DBUtils() {}
	
	public static DBUtils getInstance() throws SQLException {
		if(instance == null) {
			instance = new DBUtils();
			System.out.println("====== [ Opening DB Connection ] ======");
			
//			Class.forName("com.mysql.cj.jdbc.Driver");
			instance.connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("====== [ DB Connection Esatblished .... ] ======");
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void closeConnection() throws SQLException {
		if (connection != null) {
			System.out.println("====== [ Closing DB Connection ] ======");
			connection.close();
			connection = null;
		}
	}

}
