package com.guru.test.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guru.test.dao.UserDao;
import com.guru.test.model.User;
import com.guru.test.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Transactional
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
