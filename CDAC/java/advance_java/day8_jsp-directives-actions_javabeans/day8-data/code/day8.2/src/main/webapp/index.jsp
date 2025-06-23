<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>
		Welcome 2 JSP !!!!!
		<%=LocalDateTime.now()%></h3>
	<h4>
		<a href="comments.jsp">Test Comments</a>
	</h4>
	<h4>
		<a href="form.jsp">Test Scripting Elements</a>
	</h4>
	<h4>
		<a href="test1.jsp">Test Error Handling in JSP</a>
	</h4>
	<h4>
		<a href="test2.jsp">Test include directive in JSP</a>
	</h4>
	<h4>
		<a href="test4.jsp?id=100&name=pen&price=50">Test JSP Standard Action forward or include</a>
	</h4>
</body>
</html>