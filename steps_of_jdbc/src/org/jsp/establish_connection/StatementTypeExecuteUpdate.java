package org.jsp.establish_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTypeExecuteUpdate {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/yourx_e10";
			String user = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, user, password);
			
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO users VALUES(103, 'Hanuman', 'hanuman@gmail.com', 'sita@123', '7777777777')";
//					+ "(102, 'Sita', 'sita@gmail.com', 'sita@123', '7777777777')"
//					+ "(103, 'Hanuman', 'hanuman@gmail.com', 'sita@123', '7777777777')";
//			String sql = "UPDATE users SET email='ram.sita@gmail.com' WHERE id=101";
//			String sql = "SELECT * FROM users";
//			String sql = "DELETE FROM users WHERE id = 101";
			
			System.out.println(statement.executeUpdate(sql));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
