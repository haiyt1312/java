<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/students/saveOrUpdate" method="post" modelAttribute="student" enctype="multipart/form-data">
		Student ID: <form:input path="studentId"/> <form:errors path="studentId"></form:errors><br>
		Name: <form:input path="name"/> <form:errors path="name"></form:errors><br>
		Email: <form:input path="email"/> <form:errors path="email"></form:errors><br>
		Mark: <form:input path="mark"/> <form:errors path="mark"></form:errors><br>
		Faculty: <form:select path="faculty" items="${faculties }"></form:select> <br>
		Gender: <form:radiobuttons path="gender" items="${genders }"/> <br>
		Hobbies: <form:checkboxes path="hobbies" items="${hobbies }"/> <br>
		<input type="file" name="imageFile"> <br>
		
		<form:button>Save</form:button>
	</form:form>
</body>
</html>