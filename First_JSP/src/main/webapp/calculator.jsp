<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	
	<h1>Calculator</h1>
	<a href='calculator.jsp?op=add'	><button>Add</button></a>
	<a href='calculator.jsp?op=sub'	><button>Sub</button></a>
	<a href='calculator.jsp?op=mul'	><button>Mul</button></a>
	<a href='calculator.jsp?op=div'	><button>Div</button></a>
	<%
		String op = request.getParameter("op");
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
	
		if(op != null && n1 != null && n2 != null){
			int num1 = Integer.parseInt(n1);
			int num2 = Integer.parseInt(n2);
			int res = 0;
			if(op.equals("add")) res = num1 + num2;
			if(op.equals("sub")) res = num1 - num2;
			if(op.equals("mul")) res = num1 * num2;
			if(op.equals("div")) res = num1 / num2;
			
			out.println("<h4> Result: "+ res +"</h4>");
		}
		
		if(op != null && n1 == null && n2 == null){
			out.println(
					"<form action='calculator.jsp'>"+
						"<br>"+
						"<br>"+
						"<input type='hidden' name='op' value='"+ op +"'>"+
						"n1: "+
						"<input type='number' name='n1'>"+
						"<br>"+
						"<br>"+
						"n2: "+
						"<input type='number' name='n2'>"+
						"<br>"+
						"<br>"+
						"<button>Calculate</button>"+
					"</form>"
					);
			
		}
	
	%>
</body>
</html>