<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>In Logout Page</h4>
<h5>Hello, ${sessionScope.any_user.userDetail.firstName}</h5>
<h5>Your role - ${sessionScope.any_user.userDetail.role}</h5>

</body>
</html>