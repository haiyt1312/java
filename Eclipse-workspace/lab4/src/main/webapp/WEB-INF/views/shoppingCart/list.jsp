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
	<h2>Shopping Cart</h2>
	<hr>
	<table>
		<tr>
			<td>No.</td>
			<td>Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td></td>
		</tr>
		<c:set var="no" value="1"></c:set>
		<c:forEach var="item" items="${cartItems }">
			<form action="/shoppingCart/update">
				<tr>
					<td>${no }</td>
					<td>${item.name }</td>
					<td>
						<input type="hidden" name="productId" value="${item.productId }"> 
						<input type="number" value="${item.quantity }" name="quantity" onblur="this.form.submit()">
					</td>
					<td>${item.price }</td>
					<td><a href="/shoppingCart/remove/${item.productId }">Remove</a>
					</td>
				</tr>
			</form>
			<c:set var="no" value="${no + 1 }"></c:set>
		</c:forEach>
	</table>
	<a href="/products/list">Product List</a>
	<a href="/shoppingCart/checkout">Check out</a>
</body>
</html>