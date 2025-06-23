<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- render session id  --%>
<h5 align="center">Session ID - <%= session.getId() %></h5>
<%--pageContext.getSession().getId() --%>
<h5 align="center">Session ID - ${pageContext.session.id}</h5>
<%-- render ctx path using EL syntax --%>
<%-- java code request.getContextPath() --%>
<h5 align="center"> Context Path - ${pageContext.request.contextPath}</h5>
<%-- render HttpSession timeout using EL syntax --%>
<h5 align="center">  Session Time out - ${pageContext.session.maxInactiveInterval}</h5>
<%-- render context path using EL syntax --%>
<form action="display.jsp" method="post">
      <table style="background-color: lightgrey; margin: auto">
        <tr>
          <td>Enter User Email</td>
          <td><input type="email" name="em" /></td>
        </tr>
        <tr>
          <td>Enter Password</td>
          <td><input type="password" name="pass" /></td>
        </tr>

        <tr>
          <td><input type="submit" value="Display Details" /></td>
        </tr>
      </table>
    </form>
  </body>
</body>
</html>