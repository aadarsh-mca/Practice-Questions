<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<h5>Session ID - ${pageContext.session.id}</h5>
	<form action="validate.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td colspan="2" style="color: red;">${sessionScope.any_user.message}</td>
			</tr>
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