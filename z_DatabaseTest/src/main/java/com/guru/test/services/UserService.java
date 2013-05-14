package com.guru.test.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guru.test.model.User;



public interface UserService {

	public List<User> getAllUsers();
	
	void insertUser(User user);
	 
	User getUserById(int userId);
	  
	User getUser(String username);	
}
