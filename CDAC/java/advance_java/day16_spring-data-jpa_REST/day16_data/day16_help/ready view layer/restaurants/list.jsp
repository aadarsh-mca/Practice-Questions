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
	<table style="background-color: lightgrey; margin: auto" border="1">
	
		<caption>All Restaurants</caption>
		<tr>
			<th>Name</th>
			<th>City</th>
			<th>Address</th>
			<th>Desc</th>
			<th>Action</th>
		</tr>
		<c:forEach var="restaurant" items="${requestScope.restaurant_list}">
			<tr>
				<td>${restaurant.name}</td>
				<td>${restaurant.address}</td>
				<td>${restaurant.city}</td>
				<td>${restaurant.description}</td>
				<c:url var="url" 
				value="/restaurants/details?restaurant_id=${restaurant.id}"/>
				<td>
				<a href="${url}">Menu</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>