package org.jsp.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("email"));
		System.out.println(req.getParameter("number"));
		System.out.println(req.getParameter("password"));
		System.out.println(req.getParameter("role"));
		
		
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long number = Long.parseLong(req.getParameter("number"));
		String role = req.getParameter("role");
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system?user=root&password=root");
			String sqlGetEmailData = "SELECT * FROM users WHERE email = ? AND number = ?";
			ps = connection.prepareStatement(sqlGetEmailData);
			
			ps.setString(1, email);
			ps.setLong(2, number);
			
			set = ps.executeQuery();
			
			boolean uniqueData = true;
			while(set.next()) {
				if(email.equals(set.getString("email"))) {
					uniqueData = false;
					
				}
				if( number == set.getLong("number")) {
					uniqueData = false;
				}			
				
			}
			if(!uniqueData ) { // unique data
				System.out.println("Record Already exists with email or Number");
				out.println("Record Not created...");
				out.println("already record exists with the email or password");
				return;
			}else {
				String sqlInsertRecord = "Insert INTO users(name, email, password, number, role) VALUES(?,?,?,?,?)";
				ps = connection.prepareStatement(sqlInsertRecord);
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, password);
				ps.setLong(4, number);
				ps.setString(5, role);
				
				
				System.out.println("Record create Successfull");
				System.out.println(ps.executeUpdate() + " records was updated...");
				out.println("Record created succesfully....");
			}
		}
		catch(ClassNotFoundException e) {
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					out.close();
					if(set != null) set.close();
					if(ps != null ) ps.close();
					if(connection != null) connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}		
		
	}
	

}
