package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.User;
import com.masai.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService us;
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user){
		User users = us.addUser(user);
		return new ResponseEntity<User>(users, HttpStatus.CREATED);
	}
	
	@PostMapping("/admins")
	public ResponseEntity<User> addAdmin(@Valid @RequestBody User user){
		User admin = us.addAdmin(user);
		return new ResponseEntity<User>(admin, HttpStatus.CREATED);
	}

}
