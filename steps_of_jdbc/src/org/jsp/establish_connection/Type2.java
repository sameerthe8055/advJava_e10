package org.jsp.establish_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Type2 {
	public static void main(String[] args) {
		try {
			// step 1 Load and Register Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step 2: Establish Connection
			// 2.1: Create url
			String url = "jdbc:mysql://localhost:3306";
			String user = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection established Succesfully...!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
