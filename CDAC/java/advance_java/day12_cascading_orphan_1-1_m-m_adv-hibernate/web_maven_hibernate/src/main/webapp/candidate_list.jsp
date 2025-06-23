<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<h5>Hello , 
${sessionScope.user_bean.userDetails.firstName}
 ${sessionScope.user_bean.userDetails.lastName}</h5>
 <h5>Your Role - ${sessionScope.user_bean.userDetails.role}</h5>
</body>
</html>