package com.app.model;

public class Employee {

	private static String empEmail = "nagamadhu@gmail.com";
	private static String empPassword = "nagamadhu";
	
	public static int employeValidate( String email,String password) {
		int result = 0;
		if(empEmail.equals(email) && empPassword.equals(password)){
			result = 1;
		}
		return result;
	}
	
}
