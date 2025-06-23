<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="restaurant" value="${requestScope.restaurant_dtls}" />
	<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>Restaurant Details</caption>
		<tr>
			<td>Name</td>
			<td>${restaurant.name}</td>
			<td>City</td>
			<td>${restaurant.city}</td>
			<td>Address</td>
			<td>${restaurant.address}</td>
			<td>Description</td>
			<td>${restaurant.description}</td>
		</tr>
	</table>
	<br/><br/>

	<c:set var="food_items"
		value="${requestScope.restaurant_dtls.foodItems}" />
	<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>Restaurant Menu</caption>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Veg</th>
			<th>Action</th>
		</tr>
		<c:forEach var="food" items="${food_items}">
			<tr>
				<td>${food.itemName}</td>
				<td>${food.itemDescription}</td>
				<td>${food.price}</td>
				<td>${food.veg}</td>
				<c:url var="url" value="/food_items/update?id=${food.id}" />
				<td><a href="${url}">Update</a></td>
				<c:url var="url" value="/food_items/delete?id=${food.id}" />
				<td><a href="${url}">Delete</a></td>
			</tr>
		</c:forEach>		
	</table>
	
			<c:url var="url"
				value="/food_items/add" />
	<h5 align="center">
		<a href="${url}">Add New Food Item</a>
	</h5>

</body>
</html>