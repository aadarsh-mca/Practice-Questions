<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%-- Create Java Bean instance and add it under session scope --%>
<!-- UserBean any_user = new UserBean(); -->
<jsp:useBean id="any_user" class="com.voting.service.UserBean" scope="session" />

<%-- WC automatic work -- session.setAttribute("user_detail", new UserBean() -- userBean instance) --%>

<%-- Tells WC to invoke Matching setters of the Java Bean Class --%>
<%-- <jsp:setProperty property="*" name="any_user" /> --%>

<!-- any_user.setEmail(getAttribute("em")); -->
<jsp:setProperty name="any_user" property="email" param="em" />
<jsp:setProperty name="any_user" property="password" param="pass" />

<body>

<h5>User Details - <jsp:forward page="${sessionScope.any_user.authenticate()}.jsp" /> </h5>

</body>
</html>