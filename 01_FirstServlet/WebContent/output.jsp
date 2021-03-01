<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Redirect</title>
</head>
<body>
<h2> This is output file</h2>

<%= request.getAttribute("name") %>
<%
	String fullName = request.getAttribute("name").toString();
	out.print(fullName);
%>
<p> The value of 2 * 7 is :  <%= 2 * 7 %></p>

<% 

	for(int i=0; i<=10; i++){
		
		out.print(i);
	}
	
%>

<%!
	int calcLength(String string){
	
		
		return string.length();
	}
%>

<p> The length of String Sushant is  : <%=calcLength("Sushant") %></p>
</body>
</html>