package org.jsp.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.MappingMatch;

@WebServlet("/updateProfile")
public class updateProfile extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long number = Long.parseLong(req.getParameter("number"));
		
		Connection connection;
		PreparedStatement ps;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system?user=root&password=root");
			String sql = "Update users SET name=?, email=?, password=?, number=? WHERE id=?";
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setLong(4, number);
			ps.setInt(5, id);
			
			int noOfRecords = ps.executeUpdate();
			
			PrintWriter out = resp.getWriter();
			
			out.println(
					"<html>"+
					"<body>"+
						"<div align='center'>"+
						"<h1>Updated Successfully</h1>"+
						"<a href='homepage'><button>Homepage</button></a>"+
						"</div>"+
					"</body>"+
					"</html>"
					);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
