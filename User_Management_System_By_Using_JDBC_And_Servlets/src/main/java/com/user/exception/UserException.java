package com.user.exception;

public class UserException extends RuntimeException 
{
	private String exceptionMessage;
	public UserException()
	{
		
	}
	/**
	 * @param exceptionMessage
	 */
	public UserException(String exceptionMessage) 
	{
		this.exceptionMessage = exceptionMessage;
	}
	public String getExceptionMessage()
	{
		return exceptionMessage;
	}
	
}
