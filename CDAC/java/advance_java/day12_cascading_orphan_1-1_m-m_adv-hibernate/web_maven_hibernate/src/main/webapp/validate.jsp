<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%--import JSTL core tag library --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation Page</title>
</head>

<jsp:setProperty property="*" name="user_bean" />
<body>
<%--response.sendRedirect(response.encodeRedirectURL("admin_page.jsp")) --%>
	<c:redirect url="${sessionScope.user_bean.authenticateUser()}.jsp" />
</body>
</html>