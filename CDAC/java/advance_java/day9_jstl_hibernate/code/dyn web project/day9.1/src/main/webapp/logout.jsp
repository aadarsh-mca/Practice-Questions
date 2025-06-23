<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5>in logout</h5>
	<c:set var="user_dtls" value="${sessionScope.user.userDetails}" />
	<h6>Hello , ${user_dtls.firstName} ${user_dtls.lastName}</h6>
	<h6>Your role - ${user_dtls.role}</h6>
	<c:choose>
		<c:when test="${user_dtls.status}">
			<h5>You have already voted.....</h5>
		</c:when>
		<c:otherwise>
			<h5>You have cast a vote .....</h5>
		</c:otherwise>
	</c:choose>

	<%-- invalidate Http Session --%>
	${pageContext.session.invalidate()}
	<h6>You have logged out....</h6>
</body>
</html>