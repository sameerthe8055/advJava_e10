package org.jsp.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(email + "\n" + password);
		
		
		
		
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/student_management_system?user=root&password=root";
			conn = DriverManager.getConnection(url);
			
			String sql = "SELECT * FROM users WHERE email = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			set = ps.executeQuery();
			
			if(set.next()) {
				// entered email is correct/or has a record associated
				if(set.getString("password").equals(password)) {
					// password correct
//					RequestDispatcher dispatcher = req.getRequestDispatcher("homepage");
//					dispatcher.forward(req, resp);
					
//					resp.sendRedirect("homepage");
//					resp.sendRedirect("https://www.google.com");
					

					HttpSession session = req.getSession();
					session.setAttribute("id", set.getInt("id"));
					session.setAttribute("name", set.getString("name"));
					session.setAttribute("email", set.getString("email"));
					session.setAttribute("password", set.getString("password"));
					session.setAttribute("role", set.getString("role"));
					session.setAttribute("number", set.getLong("number"));
					
										
					resp.sendRedirect("homepage");
				}else {
					// password wrong
					RequestDispatcher dispatcher =  req.getRequestDispatcher("login.html");
					PrintWriter out = resp.getWriter();
					out.println("<h1>Wrong Password</h1>");
					dispatcher.include(req, resp);
				}
			}else {
				// no record found with th email
				RequestDispatcher dispatcher =  req.getRequestDispatcher("login.html");
				PrintWriter out = resp.getWriter();
				out.println("<h1>Wrong email</h1>");
				dispatcher.include(req, resp);
				
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

}
