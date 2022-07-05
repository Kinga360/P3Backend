package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Users;
import com.revature.repository.UserDAO;

@Service
public class UserServices {
	
	
	private static UserDAO ud;
	@Autowired
	public UserServices(UserDAO user) {
		this.ud=  user; 
				
	}
	
	

public static Users getUserById(int id) {
	return ud.getUsersById(id);	
}
public List<Users> getAllUsers() {
	return UserDAO.getAllUsers();
}
public static Users getByUsersName(String userName) {
	return UserDAO.getByUserName(userName);
}
}


