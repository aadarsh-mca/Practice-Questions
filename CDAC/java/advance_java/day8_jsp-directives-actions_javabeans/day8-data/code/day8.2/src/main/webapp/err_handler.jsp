<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Global Error handler Page</title>
</head>
<body>
<h5 style="color: red;">Error Message - ${pageContext.exception.message}</h5>
<h5 style="color: red;">Exception Details - ${pageContext.exception}</h5>
<h5 style="color: red;">Request URI - ${pageContext.errorData.requestURI}</h5>
<h5 style="color: red;">Error Code - ${pageContext.errorData.statusCode}</h5>



</body>
</html>