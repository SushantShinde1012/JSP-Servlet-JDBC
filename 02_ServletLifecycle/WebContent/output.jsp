<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
<h1> Profile</h1>
<p>Your Full Name is : <%= request.getAttribute("name") %> </p>
</body>
</html>