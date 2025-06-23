package com.cdac.tester;
import static com.cdac.utils.DBUtils.openConnection;
import java.sql.*;

public class TestConnection {

	public static void main(String[] args) {
		try(Connection cn=openConnection()) {
			openConnection();
			openConnection();
			System.out.println("db cn established "+cn);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
