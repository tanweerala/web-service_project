package com.cetpa.exceptions;

public class PatientNotFoundException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	public PatientNotFoundException(String message)
	{
		super(message);
	}
}
