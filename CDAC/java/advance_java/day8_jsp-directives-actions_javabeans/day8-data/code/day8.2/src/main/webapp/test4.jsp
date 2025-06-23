<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5>from 1st page....</h5>
	<%
	out.flush();
	String productDetails = request.getParameter("id") + " " + request.getParameter("name") + " "
			+ request.getParameter("price");
	pageContext.setAttribute("nm", 1000);
	request.setAttribute("nm1", productDetails);
	session.setAttribute("nm2", 1001);
	application.setAttribute("nm3", 1002);
	%>
	<jsp:include page="test5.jsp">
		<jsp:param value="stationary" name="category" />
	</jsp:include>
	<h5> back in first page .....</h5>
</body>
</html>