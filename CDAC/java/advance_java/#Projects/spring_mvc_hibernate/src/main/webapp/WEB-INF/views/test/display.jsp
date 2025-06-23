<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Inside Test Display .jsp</h2>
	<h3>Page Scope - </h3>
	<% 
		
	%>
	<h3>Current time - ${requestScope.server_time}</h3>
</body>
</html>