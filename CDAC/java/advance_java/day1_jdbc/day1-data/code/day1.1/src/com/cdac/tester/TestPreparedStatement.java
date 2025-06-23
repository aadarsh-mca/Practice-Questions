package com.cdac.tester;
import java.sql.*;
import java.util.Scanner;

import static com.cdac.utils.DBUtils.openConnection;
/*
 * Display user details(id , last name , dob)  
 * born after specific date having specific role

 */
public class TestPreparedStatement {

	public static void main(String[] args) {
		String sql="select id,last_name,dob from users where dob > ? and role=? order by dob";
		try(//sc
				Scanner sc=new Scanner(System.in);
				//1. establish singleton db connection
				Connection cn=openConnection();
				//2. create PST to hold pre-parsed n pre compiled query
				PreparedStatement pst=cn.prepareStatement(sql);
				
				) {
			System.out.println("Enter dob(yr-mon-day) n role");
			//3. set IN params - dob , role
			pst.setDate(1, Date.valueOf(sc.next()));//parses from string -> java.sql.Date
			//role
			pst.setString(2, sc.next());
			//4. execute select query n get RST
			try(ResultSet rst=pst.executeQuery()) {
				//cursor - before 1st row
				while(rst.next())
					System.out.println(rst.getInt(1)+" "
				+rst.getString(2)+" "+rst.getDate(3));
			} //rst.close
			
		} //pst , cn sc - close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
