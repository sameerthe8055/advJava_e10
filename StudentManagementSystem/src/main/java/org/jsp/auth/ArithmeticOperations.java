package org.jsp.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/doMath")
public class ArithmeticOperations extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operator = req.getParameter("operator");
		String s1 = req.getParameter("n1");
		String s2 = req.getParameter("n2");
		
		PrintWriter out = resp.getWriter();
		out.println("""
				<html>
				<style>
				div{
				
				 display: flex;
				 flex-items: column;
				 align-items: center;
				 
				 
				}
				div form{
					margin: 5px 5px;
					align: center;
				}
				body{
					margin-inline: auto;
				}
				</style>
				
				<body>
					<div align='center'>
					<form align='center' action='doMath' method='get' display='inline-block'>
						<input type='hidden' value='add' name='operator'>
						
						<button>Add</button>
					</form>
					
					
					<form align='center' action='doMath' method='get' display='inline-block'>
						<input type='hidden' value='subtract' name='operator'>
						
						<button>Subtract</button>
					</form>
					
					
					<form align='center' action='doMath' method='get'>
						<input type='hidden' value='multiply' name='operator'>
						
						<button>Multilpy</button>
					</form>
					
					
					<form align='center' action='doMath' method='get'>
						<input type='hidden' value='divide' name='operator'>
						
						<button>Divide</button>
					</form>
					</div>
					<br/>
					""");
					
					
						
//					<form align='center' action='doMath' method='get'>
//						<input type="radio" name="operator" value="add" id='add' >
//						<label for="add">Add</label>
//						
//						<input type="radio" name="operator" value="subtract" id='subtract' >
//						<label for="subtract">subtract</label>
//						
//						<input type="radio" name="operator" value="multiply" id='multiply' >
//						<label for="multiply">Multiply</label>
//						
//						<input type="radio" name="operator" value="divide" id='divide' >
//						<label for="divide">Divide</label>
			// form for operation
			if(operator != null && s1 == null && s2 == null) { 
				out.println("""
						<form action='doMath' action='get'>
							<input type='hidden' name='operator' value='%s'>
							<br/>
							
							<h3>n1:</h3> <input type='number' name='n1'>
							<h3>n2:</h3> <input type='number' name='n2'>
							
							<button>%s</button>							
						
						</form>
						""".formatted(operator, operator));
				
			}
			else if(operator != null && s1 != null && s2 != null) {
				int n1 = Integer.parseInt(s1);
				int n2 = Integer.parseInt(s2);
				int result = 0;
				
				if(operator.equals("add")) result = n1+n2; 
				else if(operator.equals("subtract")) result = n1-n2; 
				else if(operator.equals("multiply")) result = n1*n2; 
				else if(operator.equals("divide")) result = n1/n2;
				
				out.println("<h2>%d</h2>".formatted(result));
			}
			out.println("""
					</body>
					</html>
					""");
			
						
						
						

}
}
