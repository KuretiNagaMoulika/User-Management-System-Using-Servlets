package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.DTO.UserDetails;
import com.user.exception.UserException;
import com.user.service.UserService;
@WebServlet("/registration")
public class UserRegistration extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String userName=req.getParameter("username");
		String email=req.getParameter("email");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String gender=req.getParameter("gender");
		String address=req.getParameter("address");
		String password=req.getParameter("password");
		System.out.println("registerd");
		
		UserDetails userDetails=new UserDetails();
		userDetails.setName(userName);
		userDetails.setEmail(email);
		userDetails.setMobile(mobile);
		userDetails.setGender(gender);
		userDetails.setAddess(address);
		userDetails.setPassword(password);
		System.out.println("controll layer");
		System.out.println("requst");
		UserService userService=new UserService();
		PrintWriter writer=resp.getWriter();
		resp.setContentType("text/html");
		try {
		userService.userRegistration(userDetails);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/alluserdetails");
		dispatcher.forward(req, resp);
		}
		catch(UserException e)
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("UserRegistration.jsp");
			dispatcher.include(req, resp);
			writer.println(e.getExceptionMessage());
		}
	}
}
