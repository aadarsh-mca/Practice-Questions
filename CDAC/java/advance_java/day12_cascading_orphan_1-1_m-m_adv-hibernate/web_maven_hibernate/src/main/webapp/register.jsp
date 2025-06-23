<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Processing Voter Registration</title>
</head>
<%--WC tries to call ALL MATCHING setters --%>
<jsp:setProperty property="*" name="user_bean" />
<body>
	<c:set var="status"
		value="${sessionScope.user_bean.validateAndRegisterVoter()}" />
	<h5>Registration Status - ${status}</h5>
	<c:choose>
		<c:when test="${status eq 'Voter registered....'}">
	${pageContext.session.invalidate()}
	<h5>
				Proceed to <a href="login.jsp">Login</a>
			</h5>
		</c:when>
		<c:otherwise>
			<h5>
				Do you want to <a href="voter_registration.jsp">Retry</a>?
			</h5>
		</c:otherwise>
	</c:choose>
</body>
</html>