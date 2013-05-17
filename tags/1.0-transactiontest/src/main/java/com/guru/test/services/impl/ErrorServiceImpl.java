package com.guru.test.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guru.test.dao.ErrorDao;
import com.guru.test.model.Error;
import com.guru.test.services.ErrorService;

@Service
public class ErrorServiceImpl implements ErrorService {

	@Autowired
	ErrorDao errorDao;
	


	public List<Error> getAllErrors() {
		return errorDao.getAllErrors();
	}

	//with out any transaction settings, this method when called from userServiceImpl, just
	// participated in the existing transaction. 
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void insertError(Error error) {
		errorDao.insertError(error);
	}

	public List<Error> getErrorByCode(String errorCode) {
		return errorDao.getErrorByCode(errorCode);
	}
	
	
	//with out any transaction settings, this method when called from userServiceImpl, just
	// participated in the existing transaction.
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void insertError(String errorCode, String errorDescription){
		errorDao.insertError(errorCode, errorDescription);
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
}
