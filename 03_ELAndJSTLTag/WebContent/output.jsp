<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EL</title>
</head>
<body>
	<p> I am EL Expression 2*7 : ${2*7}</p>
	<p>You can write logical Expression : ${5 > 9}</p>
	<p>You can Write Ternary Opertaor using EL : ${6 ge 9 ? "Welcome":"Good Bye"}</p>
	<p>My Full  Name is : ${name}</p>
	<h2>My Wife Name is : ${student.name}</h2>
	<h3>Age is : ${student.age}</h3>
	<h3>Location is : ${student.location}</h3>
</body>
</html>