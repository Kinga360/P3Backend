package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.models.UserRole;
import com.revature.models.Users;
import com.revature.repository.UserDAO;
import com.revature.services.AuthenticationServices;


@Controller
@RequestMapping(value="/authcontroller")
@CrossOrigin
public class AuthController {
	private AuthenticationServices as;
	
	@Autowired
	public AuthController(AuthenticationServices service) {
		this.as = service;
	}
	@PostMapping
	public ResponseEntity<Users> insertUser(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setRole(UserRole.Customer);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}
		
		
	}
	@PostMapping("/contractor")
	public ResponseEntity<Users> insertUserContractor(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}
		
		
	}
	
	@GetMapping("/login")
	public ResponseEntity<Users> login(@RequestBody Users user){
		if (user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}
		else if(as.login(user.getUserName(), user.getPassword())!= null)  {
			user = as.login(user.getUserName(), user.getPassword());
			
		
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}else {
		return null;
	}
	}
}
	
	
