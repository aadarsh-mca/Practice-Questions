<%@page import="pojo.User"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%! 
	HashMap<String, User> userMap;

	public void jspInit() {
		userMap = new HashMap<>();
		userMap.put("abc@gmail.com", new User("ABC", "abc@gmail.com", "12345", 25));
		userMap.put("xyz@gmail.com", new User("XYZ", "xyz@gmail.com", "12345", 35));
	}
%>

<body>
	<%
	String email = request.getParameter("em");
	String password = request.getParameter("pass");
	
	if(userMap.containsKey(email) && userMap.get(email).getPassword().equals(password)) {
		session.setAttribute("user_details", userMap.get(email));
		
		response.sendRedirect("details.jsp");
	} else {
		%>
		
		<h5>Invalid Email / Password !!!</h5>
		<a href="login.jsp">Retry login...</a>
		
		<%
	}
	%>
	
</body>
</html>