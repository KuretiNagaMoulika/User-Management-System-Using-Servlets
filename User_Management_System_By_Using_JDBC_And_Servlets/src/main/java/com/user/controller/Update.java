package com.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.DTO.UserDetails;
import com.user.service.UserService;
@WebServlet("/update")
public class Update extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("submit"));
		String name=req.getParameter("username");
		String email=req.getParameter("email");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String address=req.getParameter("address");
		String gender=req.getParameter("gender");
		String password=req.getParameter("password");
		UserService userService=new UserService();
		UserDetails user=new UserDetails();
		user.setId(id);
		user.setName(name);
 		user.setEmail(email);
		user.setMobile(mobile);
		user.setAddess(address);
		user.setGender(gender);
		user.setPassword(password);
		userService.updateDetails(id, user);
		
		List<UserDetails> list=userService.displayAllUserDetails();
		HttpSession session=req.getSession();
		session.setAttribute("listOfUserDetails", list);
		RequestDispatcher dispatcher=req.getRequestDispatcher("AllUserDetails.jsp");
		dispatcher.forward(req, resp);
		
	}
}
