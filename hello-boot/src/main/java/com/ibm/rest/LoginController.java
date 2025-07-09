package com.ibm.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.pojo.Login;

@RestController
public class LoginController {
	
	// http://localhost:9000/login?user=zubair&pass=java
	@GetMapping(value = "/login", produces = "text/html")
	public String validate(@RequestParam("user") String username, @RequestParam("pass") String password) {
		if(username.equals("scott") && password.equals("tiger"))
			return "<h1>Login Successful</h1>";
		else
			return "<h2>Login Failed</h2>";
	}
	
	// http://localhost:9000/auth
	@GetMapping(value = "/auth", consumes = "application/json", produces = "text/html")
	public String authenticate(@RequestBody Login login) {
		if(login.getUsername().equals("scott") && login.getPassword().equals("tiger"))
			return "<h1>Login Successful</h1>";
		else
			return "<h2>Login Failed</h2>";
	}
}
