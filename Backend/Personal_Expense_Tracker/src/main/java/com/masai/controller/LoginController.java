package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.User;
import com.masai.services.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService us;
	
	@GetMapping("signIn")
	public ResponseEntity<User> getLoggedIn(Authentication auth){
		User user = us.getUserByUsername(auth.getName());
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}
	
}
