package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  // loading class in class loader
			
			String dbUrl = "jdbc:mysql://localhost:3306/iacsd2025";  // db url
			
			String username = "root";
			String password = "Arsh007$";
			
			connection = DriverManager.getConnection(dbUrl, username, password);
			
			System.out.println("========== [ Connection established ] ==========");

		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(connection != null) {
				connection.close();
			}
		}
	}

}
