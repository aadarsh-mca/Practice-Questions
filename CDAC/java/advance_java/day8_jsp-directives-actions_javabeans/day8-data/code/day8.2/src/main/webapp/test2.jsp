<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%!private int counter = 100;//instance var : page%>
<body>
	<%
	int data = 12345;//data - loca var - _jspService
	pageContext.setAttribute("nm", 12345);//nm - available to only curnt page
	%>
	<%@ include file="test3.jsp"%>
</body>
</html>