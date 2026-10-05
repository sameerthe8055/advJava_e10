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


public class GetUsers extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		
		PrintWriter out =  res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table>");

		out.println("<tr>");
		out.println("<th>id</th>");
		out.println("<th>ename</th>");
		out.println("<th>email</th>");
		out.println("</tr>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/yourx_e10?user=root&password=root";
			connection  = DriverManager.getConnection(url);
			String sql = "SELECT * FROM users";
			ps = connection.prepareStatement(sql);
			
			set = ps.executeQuery();
			
			while(set.next()) {
				out.println("<tr>");
				out.println("<td>" + set.getInt(1) + "</td>");
				out.println("<td>" + set.getString(2) + "</td>");
				out.println("<td>" + set.getString(3) + "</td>");
				out.println("</tr>");
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			
			try {
				if(set != null) {
					set.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
