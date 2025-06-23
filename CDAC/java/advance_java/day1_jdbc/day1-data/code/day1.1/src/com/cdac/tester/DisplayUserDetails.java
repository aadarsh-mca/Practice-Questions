package com.cdac.tester;

/*
 * Display all users details , using JDBC
 */
import java.sql.*;
import static com.cdac.utils.DBUtils.openConnection;

public class DisplayUserDetails {

	public static void main(String[] args) {
		try (// 1. establish singleton cn with dn
				Connection connection = openConnection();
				// 2. create statement from Connection
				Statement st = connection.createStatement();
				// 3. Execute select query to get RST object
				ResultSet rst = st.executeQuery("select * from users");) {
			// rst cursor - before the 1st row
			/*
			 * id | first_name | last_name | email 
			 * | password | dob | status | role
			 */
			while (rst.next()) {
				System.out.printf("ID %d Name %s %s Email %s "
						+ "Pwd %s DoB %s Voting Status %b Role %s %n",
						rst.getInt(1),rst.getString(2),rst.getString(3),
								rst.getString(4),rst.getString(5),
								rst.getDate(6),rst.getBoolean(7),rst.getString(8)
								);
			}
		} // rst.close , st.close , cn.close => clean up of DB resource
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over...");

	}

}
