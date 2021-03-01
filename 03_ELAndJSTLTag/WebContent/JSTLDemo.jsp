<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Exercise</title>
</head>
<body>
		<c:out value="Sushant SHinde"></c:out>
		<c:set var="i" value="10"></c:set>
		<p>Before Removing i <c:out value="${i}"></c:out></p>
		
		
		<c:set var="j" value="${10*5}"></c:set>
		<c:out value="${j}"></c:out>
		
		<c:remove var="i"/>
		<p>After Removing i : <c:out value="${i}"></c:out></p>
		
		<c:forEach items="${countries}" var="country">
			
			<p> country Name : <c:out value="${country}"></c:out></p>
			
		</c:forEach>
		
		
			
			<table border="2px">
				<tr>
					<th>Name </th>
					<th> Age</th>
					<th>Location </th>
				</tr>
				<c:forEach items="${studentList}" var="student">
				<tr>
					<td>${student.name}</td>
					<td>${student.age}</td>
					<td>${student.location}</td>
				
				</tr>
				</c:forEach>
			</table>
			
			
			
		<c:if test="${20000 > 30000 }">
			<p>This is True block </p>
		</c:if>
		
		<c:choose>
		
			<c:when test="${2000 > 2500 }">
				<p>This is true block</p>
			</c:when>
		
			<c:otherwise>
				<p>This is default Block</p>
			</c:otherwise>
		</c:choose>
		
		
		<c:out value="${f:toLowerCase('Sushant VISHAWAMBHAR SHinde') }"></c:out>
		<c:out value="${f:toUpperCase('Sushant VISHAWAMBHAR SHinde') }"></c:out>
		<c:out value="${f:length('Sushant VISHAWAMBHAR SHinde') }"></c:out>
		<c:out value="${f:contains('Sushant VISHAWAMBHAR SHinde','Sush') }"></c:out>
		
		
</body>
</html>