<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">

		<form action="${pageContext.request.contextPath}/EmployeeController" method="post">
				<input type="hidden" name="id" value="${employee.id}"/></br></br>
				Enter Name : <input type="text" name="fname" value="${employee.name}"/></br></br>
				Enter Date Of Birth : <input type="date" name="dob" value="${employee.dob}"/></br></br>
				Enter Department : <input type="text" name="department" value="${employee.department}"/></br></br>
				<button class="btn btn-primary" type="submit">Save Employee</button> 
				<button class="btn btn-primary" type="reset">Cancel</button>
			
		</form>
	</div>
</body>
</html>