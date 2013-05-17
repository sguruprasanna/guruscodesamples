package com.guru.test.dao;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guru.test.model.Error;


public interface ErrorDao {

		public List<Error> getAllErrors();
		
		void insertError(Error error);
		 
		List<Error> getErrorByCode(String errorCode);
		  
		//Error getUser(String username);
		void insertError(String errorCode, String errorDescription);

		//public void updateError(String errorCode, String errorDescription);

}
