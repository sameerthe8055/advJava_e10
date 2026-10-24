<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello From JSP</h1>

<%! List list; %>
<%
	//responce
	String name = "Ram";
	
	//out
	out.println("<h5>" +name+"</h5>");

%>
	<%!public static int square(int num){
		return num*num;
		
	}
%>
	<h1>
		name is : 
		<%=name %></h1>
	<h5>
		square of 4 is
		<%=square(4) %></h5>
		
		<%!public static boolean palindrome(int n){
			int result = 0;
			int temp =n;
			while(n!=0){
				int r = n%10;
				result=result*10+r;
				n/=10;
				
			}
			
			if(temp==result)
				return true;
				
			else
				return false;
		}
		
		
		%>
		
	<% 
	int num = 221;
	boolean res = palindrome(num);
			out.println("check: "+ num + " "+ ( res ?"palindrome":"not a palindrome"));
	%>

	<%!public static int count1(int n){
		int count =0;
		while(n!=0){
			n/=10;
			count++;
			
		}
		return count;
	}%>
	
	<h1>
		count of Number is :--->
		<%=count1(2026)%>
	</h1>
	<%
		String name1 = "Pawankalyan";
	out.println("<h1>" +name1+"</h1>");
	
	%>
	<h1>
	The Name Is :--->
	<%=name1 %>
	</h1>
</body>
</html>
