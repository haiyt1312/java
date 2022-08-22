<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>Product ID</td>
			<td>Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td></td>
		</tr>
		<c:forEach var="item" items="${products }">
			<tr>
				<td>${item.productId }</td>
				<td>${item.name }</td>
				<td>${item.quantity }</td>
				<td>${item.price }</td>
				<td>
					<a href="/shoppingCart/add/${item.productId }">Add to Cart</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/shoppingCart/list">Shopping Cart</a>
</body>
</html>