<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%--import JSTL supplied core tag library --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%--create java bean instance n add it under session scope --%>
<%-- WC : session.setAttribute("user",new UserBean()) --%>
<jsp:useBean id="user" class="com.voting.service.UserBean"
	scope="session" />
<%--add candidate bean under application scope --%>
<jsp:useBean id="candidate" class="com.voting.service.CandidateBean"
	scope="application" />
<%--Tells WC to invoke MATCHING setters of the java bean class --%>
<jsp:setProperty property="*" name="user" />
<body>
	<%-- redirect the clnt to the next page as per the outcome in the NEXT request--%>
	<h5>
		<c:redirect url="${sessionScope.user.authenticate()}.jsp" />
	</h5>
</body>
</html>