package org.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Signup extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		int id = Integer.parseInt(req.getParameter("id"));
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long number = Long.parseLong(req.getParameter("number"));
		
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/yourx_e10";
			String user = "root";
			String password1 = "root";
			conn = DriverManager.getConnection(url, user, password1);
			String sql = "INSERT INTO users VALUES(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1, id);
			ps.setString(2, uname);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setLong(5, number);
			
			System.out.println("No of rows affected: " + ps.executeUpdate());
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {			
			if(ps != null)
				try {
					if(ps != null)ps.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		
	}

}
