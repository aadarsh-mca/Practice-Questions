<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body {
		display: flex;
		flex-direction: column;
	}
	
	div {
        text-align: center;      /* Centers text inside the div */
    }
</style>
</head>
<body>

<div>
	<h5>Session ID (tag) - <%= session.getId() %></h5>
	<h5>Session ID (EL syntax) - ${pageContext.session.id}</h5>
	<h5>Context Path - </h5>
	<h5>Session Timeout - </h5>
</div>

<form action="display.jsp" method="get">
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