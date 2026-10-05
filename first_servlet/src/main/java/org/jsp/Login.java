package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(email + "\n" + password);
		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/yourx_e10?user=root&password=root";
			conn = DriverManager.getConnection(url);
			
			String sql = "SELECT * FROM users WHERE email=?";
//			String sql = "SELECT * FROM users WHERE email = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			set = ps.executeQuery();
			
			if(set.next()) {
				// entered email is correct/or has a record associated
				if(set.getString("password").equals(password)) {
					// password correct
					out.println("<h1>Login Successfull</h1>");					
				}else {
					// password wrong
					out.println("<h1>Wrong Password</h1>");
				}
			}else {
				// no record found with th email
				out.println("<h1>Wrong email</h1>");
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(set != null) {
						set.close();
					}
					if(ps != null) {
						ps.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		
	}
	
	
	
	
	/*

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");	
		String password = req.getParameter("password");
		System.out.println(email);
		System.out.println(password);
	}
	*/

}
