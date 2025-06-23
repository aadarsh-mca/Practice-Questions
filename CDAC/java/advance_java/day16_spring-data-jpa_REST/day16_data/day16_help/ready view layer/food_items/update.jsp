<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Food Item Details</title>
</head>

<body>

	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Food Item ID</td>
				<td><input type="number" name="id" value="${food_item.id}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Update Description</td>
				<td><textarea cols="40" rows="10" name="desc">${food_item.itemDescription}</textarea></td>
			</tr>
			<tr>
				<td>Update Price</td>
				<td><input type="number" name="price"
					value="${food_item.price}" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update Food Item Details" /></td>
			</tr>
		</table>
	</form>
</body>
</html>