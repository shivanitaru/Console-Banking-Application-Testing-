package com.exception;
public class PassIncorrect extends Exception {
	String pass;
	public PassIncorrect(String s) 
	{
		pass=s;
	}
	
	@Override
	public String toString()
	{
		return ("Password Incorrect!!");
	}
}
