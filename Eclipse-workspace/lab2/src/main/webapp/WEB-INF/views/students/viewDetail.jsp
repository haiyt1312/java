<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Detail</h1>
	<hr>
	<h3>Student ID: ${studentId}</h3>
	<h3>Name: ${name}</h3>
	<p>
		<a href="/students/edit/${studentId }">Edit Student</a>
	</p>
	<hr>
	<a href="/">Home</a>
</body>
</html>