<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome 2 Spring MVC !!!!</h3>
	<h4>
		<a href="test/test1">Test Model And View</a>
	</h4>
	<h4>
		<a href="test/test2">Test Model Map</a>
	</h4>
	<c:url var="abc" value="/restaurants/list"/>
	<h5><a href="${abc}">List All Restaurants</a></h5>
</body>
</html>