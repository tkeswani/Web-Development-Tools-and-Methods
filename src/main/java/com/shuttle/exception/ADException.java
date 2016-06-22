package com.shuttle.exception;

public class ADException extends Exception {
	
	public ADException(String message)
	{
		super(message);
	}
	
	public ADException(String message, Throwable cause)
	{
		super(message,cause);
	}

}
