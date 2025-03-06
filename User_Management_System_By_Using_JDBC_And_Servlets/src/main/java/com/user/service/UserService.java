package com.user.service;

import java.util.List;

import com.user.DAO.UserDAO;
import com.user.DTO.UserDetails;
import com.user.exception.UserException;

public class UserService
{
	UserDAO userDAO=new UserDAO();
	public void userRegistration(UserDetails userDetails)
	{
		UserDetails userDetails2=new UserDetails();
		long mobile=userDetails.getMobile();
		if(mobile>=6000000000l && mobile<=9999999999l)
		{
			userDetails2.setMobile(mobile);
		}
		else
		{
			throw new UserException("Invalid Mobile number");
		}
		String password=userDetails.getPassword();
		if (password.length()>=4 && password.length()<=8) 
		{
			userDetails2.setPassword(password);
		}
		else 
		{
			throw new UserException("Invalid password");
		}
		userDetails2.setName(userDetails.getName());
		userDetails2.setEmail(userDetails.getEmail());
		userDetails2.setAddess(userDetails.getAddess());
		userDetails2.setGender(userDetails.getGender());
		System.out.println("service layer");
		userDAO.insertUserDetails(userDetails2);
	}
	public List<UserDetails> displayAllUserDetails() 
	{
		return userDAO.displayDetails();

	}
	public List<UserDetails> displayFilterDetails(String filter)
	{
		return userDAO.displayFilterDetails(filter);
	}
	public void  deleteDetails(int id)
	{
		userDAO.deleteDetails(id);
	}
	public void updateDetails(int id,UserDetails userDetails)
	{
		userDAO.updateDetails(id, userDetails);
	}
	public UserDetails getUserDetails(int id)
	{
		return userDAO.getUserDetails(id);
	}
}
