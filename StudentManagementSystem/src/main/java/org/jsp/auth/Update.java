package org.jsp.auth;

import java.io.IOException;
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

@WebServlet("/update")
public class Update extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String page = req.getParameter("page");
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/student_management_system?user=root&password=root";
			connection = DriverManager.getConnection(url);
			
			String sql = "SELECT * FROM users WHERE id=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			set = ps.executeQuery();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(set != null) set.close();
					if(ps != null) ps.close();
					if(connection != null) connection.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(page != null) resp.sendRedirect(page);	
				else resp.sendRedirect("homepage");
			}
		
	}
}
