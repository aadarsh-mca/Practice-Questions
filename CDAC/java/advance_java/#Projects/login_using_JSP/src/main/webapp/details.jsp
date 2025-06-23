<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Logged in User Details :: </h4>
	<br/>
	<h4>RequestScope Map :: ${requestScope}</h4>
	<br/>
	<h4>SessionScope Map :: ${sessionScope}</h4>
	<br/>
	<h4>Session Id :: ${pageContext.session.id}</h4>
	<br/>
	<h4>Session Timeout :: ${pageContext.session.maxInactiveInterval}</h4>
	<br/>
	
	<h5>Name :: ${sessionScope.user_details.getName()}</h5>
	<h5>Email :: ${sessionScope.user_details.email}</h5>
	<h5>Age :: ${sessionScope.user_details.age}</h5>

	<h5>
		<a href="logout.jsp">Logout...</a>
	</h5>
</body>
</html>