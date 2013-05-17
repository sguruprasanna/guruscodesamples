package com.guru.test.dao;

import java.util.List;

import com.guru.test.model.User;

public interface UserDao {

	public List<User> getAllUsers();
	
	void insertUser(User user);
	 
	User getUserById(int userId);
	  
	User getUser(String username);
	
	void updateAvailability(User user, boolean available);
	
	//void updateError(String errorCode, String errorDescription);
}
