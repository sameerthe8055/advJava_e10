package com.sameer_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class practise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/yourx_e10?user=root&password=root";
			Connection connection = DriverManager.getConnection(url);
			
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM users";
			
			ResultSet set = statement.executeQuery(sql);
			
			while(set.next()) {
				int id = set.getInt("id");
				String uName = set.getString("uname");
				String email = set.getString("email");
				String password = set.getString("password");
				
				System.out.println(id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
