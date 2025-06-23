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
	<h5>in admin page</h5>
	<jsp:useBean id="user" class="com.voting.service.UserBean"
		scope="session" />
	<h5 style="color: green;">${sessionScope.user.message}</h5>
	<%--session.getAttribute("user").getUserDetails().getFirstName() --%>
	<h6>Hello , ${sessionScope.user.userDetails.firstName}
		${sessionScope.user.userDetails.lastName}</h6>
	<h6>Your role - ${sessionScope.user.userDetails.role}</h6>
	<%-- render list of top2 candidates --%>
	<%-- 	<h5>Top 2 candidates - </h5>
 --%>
	<table style="background-color: lightgrey; margin: auto">
		<caption>Top 2 Candidates</caption>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Party</th>
			<th>Votes</th>
		</tr>
		<c:forEach var="candidate"
			items="${applicationScope.candidate.topCandidates}">
			<tr>
				<td>${candidate.candidateId}</td>
				<td>${candidate.name}</td>
				<td>${candidate.partyName}</td>
				<td>${candidate.votes}</td>
			<tr>
			</tr>
		</c:forEach>
	</table>
	<%-- render the map --%>
	<%-- 	<h5>Party n votes - ${applicationScope.candidate.fetchResults()}
 </h5>--%>
	<table style="background-color: lightgrey; margin: auto">
		<caption>Partywise Votes</caption>
		<tr>
			<th>Party Name</th>
			<th>Votes</th>
		</tr>
		<c:forEach var="entry"
			items="${applicationScope.candidate.fetchResults()}">
			<tr>
				<td>${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</table>


	<%--invalidate session --%>
	${pageContext.session.invalidate()}
	<h6>admin has logged out....</h6>
	<h5>
		<a href="login.jsp">Visit Again</a>
	</h5>

</body>
</html>