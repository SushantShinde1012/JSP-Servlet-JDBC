<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List All Employee</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
	<div class="container">
	<p>${message}</p>
	<button class="btn btn-primary" onclick="window.location.href='views/employee-add.jsp'">Add Employee</button>
		<table border="1" class="table table-striped table-bordered">
		<tr class="thead-dark">
		
			<th>Employee Name</th>
			<th>Employee DOB</th>
			<th>Department</th>
			<th>Actions</th>
		</tr>
		<c:forEach items ="${listEmployee}" var="employee">
		<tr>
			
			<td>${employee.name}</td>
			<td>${employee.dob}</td>
			<td>${employee.department}</td>
			<td>
			<a href="${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.id}">Edit</a>
			|<a href="${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${employee.id}">Delete</a>
					
			</td>
	</tr>
	</c:forEach>
	</table>
	
	
	</div>
	
	
</body>
</html>