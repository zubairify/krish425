package com.ibm.rest;


public class LoginController {

	public String validate(String username, String password) {
		if(username.equals("scott") && password.equals("tiger"))
			return "<h1>Login Successful</h1>";
		else
			return "<h2>Login Failed</h2>";
	}
}
