<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	button{
		padding: px 20px;
	}
</style>
<body align="center">
	
	<h1>Calculator</h1>
	<form action="calculator.jsp">
		N1: <input type="number" name="n1">
		<br>
		N2: <input type="number" name="n2">
		<br>
		<select name="op">
			<option value="add">Add</option>		
			<option value="sub">Sub</option>		
			<option value="mul">Mul</option>		
			<option value="div">Div</option>		
		</select>
		<button>Calculate</button>
	</form>
	
	<%
		String n1s = request.getParameter("n1");
		String n2s = request.getParameter("n2");
		String op = request.getParameter("op");
		
		if(op != null && n1s != null && n2s != null){
			int n1 = Integer.parseInt(n1s);
			int n2 = Integer.parseInt(n2s);
			int res;
			switch(op){
				case "add":{
					res = n1+n2;
					%>
						<h1>Addidtion is <%= res %></h1>
					<% 
					break;
				}
				case "sub":{
					res = n1-n2;
					%>
						<h1>Addidtion is <%= res %></h1>
					<% 
					break;
				}
				case "mul":{
					res = n1*n2;
					%>
						<h1>Addidtion is <%= res %></h1>
					<% 
					break;
				}
				case "div":{
					res = n1/n2;
					%>
						<h1>Addidtion is <%= res %></h1>
					<% 
					break;
				}
			}
		}
	%>
	
</body>
</html>