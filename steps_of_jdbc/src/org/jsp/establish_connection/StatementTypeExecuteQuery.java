package org.jsp.establish_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTypeExecuteQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet set = null;
		
		
		try {
			// Step1
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step2
			String url = "jdbc:mysql://localhost:3306/yourx_e10";
			String user = "root";
			String password = "root";
			connection = DriverManager.getConnection(url, user, password);
			
			// create SQL statement
			statement = connection.createStatement();
			String sql = "SELECT * FROM users";
			set = statement.executeQuery(sql);
			
			while(set.next()) {
				System.out.println("===========");
				System.out.println(set.getInt("id"));
				System.out.println(set.getInt(1));
				System.out.println(set.getString("uname"));
				System.out.println(set.getString("email"));
				System.out.println(set.getLong("number"));
				
			}
			System.out.println("succsfull");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try 
				{
					if(set != null) set.close();
					if(statement != null) statement.close();
					if(connection != null) connection.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}


