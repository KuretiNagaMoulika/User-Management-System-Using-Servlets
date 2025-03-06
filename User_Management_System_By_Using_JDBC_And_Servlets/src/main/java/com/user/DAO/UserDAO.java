package com.user.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.user.DTO.UserDetails;

public class UserDAO
{
	private static final String url="jdbc:mysql://localhost:3306/teca_65_advance_java?user=root&password=root";
	private static final String insert_query="insert into user_registration(User_name,User_email,User_mobile,User_address,User_gender,user_password) values(?,?,?,?,?,?)";
	private static final String display_query="select * from user_registration";
	private static final String delete_query="delete from user_registration where User_id=?";
	private static final String update_query="update user_registration set User_name=?,User_email=?,User_mobile=?,User_address=?,User_gender=?,user_password=? where User_id=?";
	private static final String get_user_details_query="select * from user_registration where User_id=?";
	private static final String filter_details_query="select * from user_registration where User_name=? or User_email=? or User_mobile=? or User_address=? or User_gender=? or user_password=?";
	public void insertUserDetails(UserDetails userDetails)
	{
		//Insert
		String userName=userDetails.getName();
		String email=userDetails.getEmail();
		long mobile=userDetails.getMobile();
		String address=userDetails.getAddess();
		String gender=userDetails.getGender();
		String password=userDetails.getPassword();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(insert_query);
			ps.setString(1, userName);
			ps.setString(2, email);
			ps.setLong(3, mobile);
			ps.setString(4, address);
			ps.setString(5, gender);
			ps.setString(6, password);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		displayDetails();
	}
	public void deleteDetails(int id)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(delete_query);
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void updateDetails(int id,UserDetails userDetails)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(update_query);
			ps.setString(1, userDetails.getName());
			ps.setString(2, userDetails.getEmail());
			ps.setLong(3, userDetails.getMobile());
			ps.setString(4, userDetails.getAddess());
			ps.setString(5, userDetails.getGender());
			ps.setString(6, userDetails.getPassword());
			ps.setInt(7, id);
			ps.executeUpdate();
			System.out.println("update qury");
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UserDetails getUserDetails(int id)
	{
		UserDetails userDetails=new UserDetails();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(get_user_details_query);
			ps.setInt(1, id);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				userDetails.setId(set.getInt(1));
				userDetails.setName(set.getString(2));
				userDetails.setEmail(set.getString(3));
				userDetails.setMobile(set.getLong(4));
				userDetails.setAddess(set.getString(5));
				userDetails.setGender(set.getString(6));
				userDetails.setPassword(set.getString(7));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDetails;
	}
	public List<UserDetails> displayDetails()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(display_query);
			ResultSet set=ps.executeQuery();
			List<UserDetails> list=new ArrayList<UserDetails>();
			while(set.next())
			{
				UserDetails userDetails=new UserDetails();
				userDetails.setId(set.getInt("User_id"));
				userDetails.setName(set.getString("User_name"));
				userDetails.setEmail(set.getString("User_email"));
				userDetails.setMobile(set.getLong("User_mobile"));
				userDetails.setAddess(set.getString("User_address"));
				userDetails.setGender(set.getString("User_gender"));
				userDetails.setPassword(set.getString("user_password"));
				list.add(userDetails);
			}
			con.close();
			return list;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally 
		{
			
		}
	}
	public List<UserDetails> displayFilterDetails(String filter)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(filter_details_query);
			ps.setString(1, filter);
			ps.setString(2, filter);
			ps.setString(3, filter);
			ps.setString(4, filter);
			ps.setString(5, filter);
			ps.setString(6, filter);
			ResultSet set=ps.executeQuery();
			List<UserDetails> list=new ArrayList<UserDetails>();
			while(set.next())
			{
				UserDetails userDetails=new UserDetails();
				userDetails.setId(set.getInt("User_id"));
				userDetails.setName(set.getString("User_name"));
				userDetails.setEmail(set.getString("User_email"));
				userDetails.setMobile(set.getLong("User_mobile"));
				userDetails.setAddess(set.getString("User_address"));
				userDetails.setGender(set.getString("User_gender"));
				userDetails.setPassword(set.getString("user_password"));
				list.add(userDetails);
			}
			con.close();
			return list;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally 
		{
			
		}
	}
}
