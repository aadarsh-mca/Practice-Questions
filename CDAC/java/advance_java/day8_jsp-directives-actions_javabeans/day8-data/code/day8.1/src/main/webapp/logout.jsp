<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5>Hello , ${sessionScope.user_details.name}</h5>
	<%-- <%
	session.invalidate();
	%> --%>
	${pageContext.session.invalidate()}
	<h6>You have logged out.....</h6>
	<h5>
		<a href="login.jsp">Visit Again</a>
	</h5>
	
</body>
</html>