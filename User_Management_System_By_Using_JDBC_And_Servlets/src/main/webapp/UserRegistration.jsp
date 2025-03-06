<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="registration" method="get">
	<input type="text" name="username" placeholder="Enter your Name:"><br>
	<input type="email" name="email" placeholder="Enter Email ID:"><br>
	<input type="number" name="mobile" placeholder="Enter mobile Number:"><br>
	<input type="radio" name="gender" value="male">MALE
	<input type="radio" name="gender" value="female">FEMALE
	<input type="radio" name="gender" value="others">OTHERS<br>
	<textarea rows="5" cols="20" placeholder="Address" name="address"></textarea><br>
	<input type="password" name="password" placeholder="create password"><br>
	<input type="submit">
	</form>
</body>
</html>