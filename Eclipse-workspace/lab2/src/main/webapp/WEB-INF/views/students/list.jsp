<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href="/">
</head>
<body>
	<h1>List of Students</h1>
	<hr>
	<table>
		<tr>
			<td>Student ID</td>
			<td>Name</td>
			<td></td>
		</tr>
		<c:forEach var="item" items="${students}">
			<tr>
				<td>${item.studentId }</td>
				<td>${item.name }</td>
				<td><a href="students/viewDetail/${item.studentId }">View</a> <a
					href="students/edit/${item.studentId }">Edit</a> <a
					href="students/delete/${item.studentId }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>