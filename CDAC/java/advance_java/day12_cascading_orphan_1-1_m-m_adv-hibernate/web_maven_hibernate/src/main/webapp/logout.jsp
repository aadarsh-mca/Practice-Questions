<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout page</title>
</head>
<body>
	<%--session.getAttribute("user_bean").getUserDetails().getFirstName() --%>
	<c:set var="user_role"
		value="${sessionScope.user_bean.userDetails.role}" />
	<h4>Hello , ${sessionScope.user_bean.userDetails.firstName}
		${sessionScope.user_bean.userDetails.lastName}</h4>
	<h5>You have logged in under ${user_role} role</h5>
	<%-- invalidate session --%>
	<%
	session.invalidate();
	%>
	<h5>You have logged out.....</h5>
	<%--Display visit again link only for admin--%>
	<c:if test="${user_role eq 'admin'}">
		<h5>
			<a href="index.jsp">Visit Again</a>
		</h5>
	</c:if>
</body>
</html>