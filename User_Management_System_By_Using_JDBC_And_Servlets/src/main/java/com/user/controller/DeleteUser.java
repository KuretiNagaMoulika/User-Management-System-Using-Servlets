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
import javax.servlet.http.HttpSession;

import com.user.DAO.UserDAO;
import com.user.DTO.UserDetails;
import com.user.service.UserService;

@WebServlet("/deleteform")
public class DeleteUser extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("userId"));
		
		UserService userService=new UserService();
		userService.deleteDetails(id);
		
		List<UserDetails> allUserDetails=userService.displayAllUserDetails();
		HttpSession session=req.getSession();
		session.setAttribute("listOfUserDetails", allUserDetails);
		System.out.println(allUserDetails);
		RequestDispatcher disptcher=req.getRequestDispatcher("AllUserDetails.jsp");
		disptcher.forward(req, resp);
	}
}
