<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- /restaurants/details?restaurant_id=1 -->
<h3>Restaurant Details :: ${requestScope.restaurant_details}</h3>

<h3>Food Items 1 :: ${requestScope.restaurant_details.foodItems}</h3>

</body>
</html>