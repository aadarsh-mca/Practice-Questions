<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Food Item</title>
</head>

<body>
	<h5 align="center" style="color: red;">${requestScope.status}</h5>

	<form:form method="post" modelAttribute="foodItem">
		<table style="background-color: lightgrey; margin: auto">
			
			<tr>
				<td>Enter Food Item Name</td>
				<td><form:input path="itemName" /></td>
			</tr>
			<tr>
				<td>Enter Description</td>
				<td><form:textarea path="itemDescription" /></td>
			</tr>
			<tr>
				<td>Enter Price</td>
				<td><form:input type="number" path="price" /></td>
			</tr>
			<tr>
				<td>Type</td>
				<td><form:radiobutton path="veg" value="true" />Veg</td>
				<td><form:radiobutton path="veg" value="false" />Non Veg</td>
			</tr>
			<tr>
				<td><input type="submit" value="Add New Food Item" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>