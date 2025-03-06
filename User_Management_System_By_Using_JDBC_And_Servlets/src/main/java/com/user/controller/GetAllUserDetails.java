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
@WebServlet("/alluserdetails")
public class GetAllUserDetails extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		UserService userService=new UserService();
		List<UserDetails> list=userService.displayAllUserDetails();
		HttpSession session=req.getSession();
		session.setAttribute("listOfUserDetails", list);
		RequestDispatcher dispatcher=req.getRequestDispatcher("AllUserDetails.jsp");
		dispatcher.forward(req, resp);
	}
}
