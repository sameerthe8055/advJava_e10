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

@WebServlet("/addStudent")
public class AddStudent extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		long number = Long.parseLong(req.getParameter("number"));
		
		Connection connection;
		ResultSet set;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system?user=root&password=root");
			String sql = "INSERT INTO users(name, email, password, number, role) VALUES(?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setLong(4, number);
			ps.setString(5, role);
			
			int updatedRecords = ps.executeUpdate();
			
			System.out.println("Updated Records: " + updatedRecords);
			PrintWriter out = resp.getWriter();
			out.println("<h1>Record created Sucessfully with details<h1/>");
			out.println("name: %s\temail: %s\tnumeber: %drole: %s ".formatted(name,email,number, role));
			out.println("<br/>");
			out.println("<a href='homepage'><button>Homepage<button></a>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
