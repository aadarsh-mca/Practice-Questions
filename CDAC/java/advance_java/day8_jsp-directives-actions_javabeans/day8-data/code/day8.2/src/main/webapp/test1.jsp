<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int result = 100 /0;//result : method local var
	pageContext.setAttribute("res", result);//res - page scoped attribute
	%>
	<h5>Local Var - <%= result %></h5>
	<h5>Page Scoped Attribute - ${pageScope.res}</h5>
</body>

</html>