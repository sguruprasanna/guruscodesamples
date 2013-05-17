package com.guru.test.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guru.test.dao.ErrorDao;
import com.guru.test.dao.UserDao;
import com.guru.test.model.User;
import com.guru.test.services.ErrorService;
import com.guru.test.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ErrorDao errorDao;
	
	@Autowired
	private ErrorService errorService;
	

	@Transactional(propagation=Propagation.REQUIRED)
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	public User getUserById(int userId) {
		return null;
	}

	public User getUser(String username) {
		return null;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	//@Transactional(propagation=Propagation.NESTED)
	//@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateAvailability(User user, boolean available) {

			userDao.updateAvailability(user, available);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	//@Transactional(propagation=Propagation.REQUIRES_NEW)
	//@Transactional(propagation=Propagation.NESTED)
	// none of the above transaction propagation settings created a new transaction, as this method is in 
	// the same service implmentation class.. 
	// This proves that spring will have one physical transaction per serice. If a method needs 
	// needs to be executed in a seperate transaction, it has to be marked with REQUIRES_NEW in a seperate service or DAO.
	public void insertError(String errorCode, String errorDescription) {
		errorService.insertError(errorCode,errorDescription);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateUserDetails(User user, boolean available) {
		
		try {
			insertUser(user);
			System.out.println(">>> Insert completed.");
			System.out.println(">>> Calling updateAvailability()...");
			updateAvailability(user, available);
		} catch(Exception e){
			System.out.println(">>> Exception occured...");
			e.printStackTrace();
			
			//errorDao.updateError("USER_AVAIL_ERROR","Error updating user availability...");
			insertError("USER_AVAIL_ERROR","Error updating user availability...");
		}
		
	}
	
	
	
	/**
	 * @return the errorDao
	 */
	public ErrorDao getErrorDao() {
		return errorDao;
	}

	/**
	 * @param errorDao the errorDao to set
	 */
	public void setErrorDao(ErrorDao errorDao) {
		this.errorDao = errorDao;
	}

	/**
	 * @return the errorService
	 */
	public ErrorService getErrorService() {
		return errorService;
	}

	/**
	 * @param errorService the errorService to set
	 */
	public void setErrorService(ErrorService errorService) {
		this.errorService = errorService;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
