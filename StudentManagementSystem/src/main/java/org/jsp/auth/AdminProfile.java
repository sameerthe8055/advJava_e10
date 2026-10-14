package org.jsp.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin_profile")
public class AdminProfile extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");
		long number = (long) session.getAttribute("number");
		PrintWriter out = resp.getWriter();
		
		out.println(""+
		"<html>"+
		"<body>"+
		"<h1 align='center'>Admin Profile</h1>"+
		"<form action='updateProfile' method='post' align='center'>"+
			"<input type='hidden' name='id' value='%d'>".formatted(id)+ 
			"Name: <br><input type='text' name='name' value='%s'>".formatted(name)+ 
			"<br>"+
			"Email: <br><input type='email' name='email' value='%s'>".formatted(email)+ 
			"<br>"+
			"Password: <br><input type='password' name='password' value='%s'>".formatted(password)+ 
			"<br>"+
			"Number: <br><input type='number' name='number' value='%d'>".formatted(number)+ 
			"<br>"+
			"<button>Update</button>"+
		"</form>"+
		"</body>"+
		"</html>"
				);
	}
	

}
