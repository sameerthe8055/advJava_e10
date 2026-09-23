package org.jsp.establish_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Type1 {
	public static void main(String[] args) {
		try {
			// step 1 Load and Register Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step 2: Establish Connection
			// 2.1: Create url
			String url = "jdbc:mysql://localhost:3306/yourx_e10?user=root&password=root";
			Connection connection = DriverManager.getConnection(url);
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
