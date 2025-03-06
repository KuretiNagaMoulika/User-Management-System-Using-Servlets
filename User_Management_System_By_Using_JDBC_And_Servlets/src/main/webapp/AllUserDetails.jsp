<%@page import="java.util.Iterator"%>
<%@page import="com.user.DTO.UserDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All User Details</title>
</head>
<body>
	<h1>All USER DETAILS</h1>
	<% 
	List<UserDetails> list=(List<UserDetails>)session.getAttribute("listOfUserDetails"); 
	%>
	<center>
	<form action="filterdata" method="get">
	<input type="text" placeholder="enter name or email or mobile or gender or address" name="filter">
	<input type="submit">
	</form>
	</center>
	<table border='1px solid red'">
		<tr>
			<th>ID</th>
			<th>USERNAME</th>
			<th>EMAIL</th>
			<th>MOBILE NUMBER</th>
			<th>ADDRESS</th>
			<th>GENDER</th>
			<th>PASSWORD</th>
			<th>ACTIVITY</th>
		</tr>
		<%
		Iterator<UserDetails> itr=list.iterator();
		while(itr.hasNext())
		{
			UserDetails userDetails=itr.next();
			out.print("<tr>");
			out.print("<td>"+userDetails.getId()+"</td>");
			out.print("<td>"+userDetails.getName()+"</td>");
			out.print("<td>"+userDetails.getEmail()+"</td>");
			out.print("<td>"+userDetails.getMobile()+"</td>");
			out.print("<td>"+userDetails.getAddess()+"</td>");
			out.print("<td>"+userDetails.getGender()+"</td>");
			out.print("<td>"+userDetails.getPassword()+"</td>");
			out.print("<td><form action='updateform' method='get'><input class='id' name='userId' hidden='true' value="+userDetails.getId()+
					"><input type='submit' value='Update'> </form><form action='deleteform' method='get'><input class='id' name='userId' hidden='true' value="+userDetails.getId()+
			"><input type='submit' value='delete'> </form></td>");
			out.print("</tr>");
		}
		out.print("</table>");
		%>
	
</body>
</html>