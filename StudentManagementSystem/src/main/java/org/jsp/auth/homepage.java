package org.jsp.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/homepage")
public class homepage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
//		out.println("""
//				<html>
//				<body>
//				<h1>Welcome to home page</h1>
//				<a><button>add Student</button><a>
//				</body>
//				</html>
//				""");
//		// getting parameter from sendRedirect
//		int id = Integer.parseInt(req.getParameter("id"));
//		String name = req.getParameter("name");
		
		HttpSession session = req.getSession();
		String name = (String)session.getAttribute("name");
		int id = (int)session.getAttribute("id");
		out.println("""
				<html>
				<body>
				<h1>Welcome to home page</h1>
				"""+
				"<h1>id: " + id+ " <h1>"+
				"<h1>name: " + name+ " <h1>"+
				"<a href='add_student.html'><button>add Student</button><a>"+
				"<br/>"+
				"<a href='admin_profile'><button>Profile</button><a>"+
				"<a href='allStudents'><button>Show Students</button><a>"+
				
				"</body>"+
				"</html>"
				);
		
	}

}
