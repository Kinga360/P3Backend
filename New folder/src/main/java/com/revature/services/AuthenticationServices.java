package com.revature.services;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.revature.models.Users;
import com.revature.repository.UserDAO;

@Service
public class AuthenticationServices {
	
UserDAO userDAO = new UserDAO();
	
	public  Users login(String username, String password) {
		 Users user = new Users();
		try {
			user = UserDAO.getByUserName(username);
			if(user != null && password.equals(user.getPassword())) {
				
				System.out.println("Logged In Successfully");
				return user;
				
			} else {	
				System.out.println("User Does Not Exist!");
				return user;
			}
		}catch(Exception e) {
			System.out.println("Login Unsuccessful");
			e.printStackTrace();// Helpful debuging tool
		}
		
		// If the try-catch does not run, a null object is return and login is deemed unsuccessful
		return user;
		
	}
	public void insertUser(Users user) {
		userDAO.insertUser(user);
	}




}
