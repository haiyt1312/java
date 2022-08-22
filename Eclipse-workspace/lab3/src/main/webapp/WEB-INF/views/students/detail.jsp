<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Student ID: ${student.studentId }</h3>
	<h3>Name: ${student.name }</h3>
	<h3>Email: ${student.email }</h3>
	<h3>Mark: ${student.mark }</h3>
	<h3>Faculty: ${student.faculty }</h3>
	<h3>Gender: ${student.gender }</h3>
	<h3>Hobbies: ${student.hobbies}</h3>
	<h3>Image: <img src="/images/${student.imageUrl}"></h3>
</body>
</html>