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
@WebServlet("/updateform")
public class GetUserDetailsToUpdate extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("userId"));
			UserService userService=new UserService();
			UserDetails userDetails=userService.getUserDetails(id);
			HttpSession session=req.getSession();
			session.setAttribute("user", userDetails);
			RequestDispatcher disptcher=req.getRequestDispatcher("GetUserDetailsToUpdate.jsp");
			disptcher.forward(req, resp);
	}	
}
