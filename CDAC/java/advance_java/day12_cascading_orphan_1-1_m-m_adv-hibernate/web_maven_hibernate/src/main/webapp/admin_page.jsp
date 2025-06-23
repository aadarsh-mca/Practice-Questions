<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<h5 style="color: green;">${sessionScope.user_bean.message}</h5>

	<h5>Hello , ${sessionScope.user_bean.userDetails.firstName}
		${sessionScope.user_bean.userDetails.lastName}</h5>
	<h5>Your Role - ${sessionScope.user_bean.userDetails.role}</h5>

	<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>Top 2 Candidates</caption>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Party</th>
			<th>Votes</th>
		</tr>
		<c:forEach var="candidate"
			items="${applicationScope.candidate_bean.listCandidates()}">
			<tr>
				<td>${candidate.candidateId}</td>
				<td>${candidate.name}</td>
				<td>${candidate.party}</td>
				<td>${candidate.votes}</td>
			</tr>
		</c:forEach>
	</table>
	
	<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>Party Votes</caption>
		<tr>			
			<th>Party</th>
			<th>Votes</th>
		</tr>
		<c:forEach var="dto"
			items="${applicationScope.candidate_bean.partyVotes}">
			<tr>				
				<td>${dto.party}</td>
				<td>${dto.votes}</td>
			</tr>
		</c:forEach>
	</table>
	<h5 align="center">
		<a href="logout.jsp">Log Out</a>
	</h5>


</body>
</html>