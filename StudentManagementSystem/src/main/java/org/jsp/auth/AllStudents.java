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

@WebServlet("/allStudents")
public class AllStudents extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		
		PrintWriter out = resp.getWriter();
		
		out.println(
				"<html>"+
				"""
				<style>
				    table {
				      /* Merges cell borders into a single clean line */
				      border-collapse: collapse; 
				      width: 100%;
				    }
				    
				    th, td {
				      /* Defines the style, thickness, and color of the border */
				      border: 1px solid black; 
				      padding: 8px;
				      text-align: left;
				      padding: auto;
				      align-items: center
				    }
				    a{
						padding-x: auto
				    }
				    
				 </style>
	
				""" +
				"<body align='center'>" +
					"<h1>All Students Records<h1>"
				);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system?user=root&password=root");
			String sql = "SELECT * FROM users WHERE role='student'";
			ps = connection.prepareStatement(sql);
			set = ps.executeQuery();
			
			if(set.next()) {
				out.println(
						"<h1>Students Records</h1>" +
						"""
							<table ">
							<tr>
									<th>Name</th>
									<th>Email</th>
									<th>Password</th>
									<th>Number</th>
									<th>Role</th>
									
							</tr>
								
						"""
				);
				do {
					String name = set.getString("name");
					String email = set.getString("email");
					String password = set.getString("password");
					String role = set.getString("role");
					int id = set.getInt("id");
					long number = set.getLong("number");
					
					out.println(
							"""
								<tr>
									<td>%s</td> 
									<td>%s</td>
									<td>%s</td>
									<td>%d</td>
									<td>%s</td>
									<td><a href='update?id=%d&page=allStudents' ><button>Update</button></a></td>
									<td><a href='delete?id=%d&page=allStudents' ><button>Delete</button></a></td>
									
									
								</tr>						
							""".formatted(name, email, password, number, role, id, id)
							);
					
				}while(set.next());
				
				out.println("</table>");
			}else {
				out.println("<h1>Zero Student Records Available</h1>");
			}
			
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		out.println( 
			"</body>"+
			"</html>"
			);
	}

	}
}