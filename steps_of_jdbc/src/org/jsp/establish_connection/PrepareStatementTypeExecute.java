package org.jsp.establish_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStatementTypeExecute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/yourx_e10";
			String user = "root";
			String  password = "root";
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO users VALUES(?, ?, ?, ? ,?)";
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 104);
			ps.setString(2, "Lakshman");
			ps.setString(3, "laksh@gmail.com");
			ps.setString(4, "laksh@123");
			ps.setLong(5, 777777777L);
			
			System.out.println(ps.execute());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
