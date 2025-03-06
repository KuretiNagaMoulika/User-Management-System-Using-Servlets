package com.user.DTO;

public class UserDetails
{
	private int id;
	private String name;
	private String email;
	private long mobile;
	private String gender;
	private String addess;
	private String password;
	
	public UserDetails()
	{
		
	}

	public UserDetails(int id,String name, String email, long mobile, String gender, String addess, String password)
	{
		this.id=id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.addess = addess;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddess() {
		return addess;
	}

	public void setAddess(String addess) {
		this.addess = addess;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", gender="
				+ gender + ", addess=" + addess + ", password=" + password + "]";
	}
	
}
