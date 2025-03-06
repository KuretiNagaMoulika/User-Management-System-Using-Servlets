<%@page import="com.user.DTO.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	UserDetails userDetails=(UserDetails)session.getAttribute("user");
	%>
	<form action="update" method="get">
	<input type="text" name="username" value='<%=userDetails.getName() %>' > <br>
	<input type="email" name="email" value='<%=userDetails.getEmail()%>'><br>
	<input type="number" name="mobile" value='<%=userDetails.getMobile()%>'><br>
	<textarea name="address" rows="5" cols="20" value='<%=userDetails.getAddess()%>'></textarea><br>
	<input type="text" name="gender" value='<%=userDetails.getGender() %>'><br>
	<input type="text" name="password" value='<%=userDetails.getPassword() %>'><br>
	<button value=<%=userDetails.getId() %> type="submit" class="submit" name="submit">Submit</button>
	</form>
	
</body>
</html>