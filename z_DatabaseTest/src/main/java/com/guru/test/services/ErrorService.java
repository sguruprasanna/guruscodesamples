package com.guru.test.services;

import java.util.List;
import com.guru.test.model.Error;

public interface ErrorService {	
	
	public List<Error> getAllErrors();
	
	public void insertError(Error error);
	 
	public List<Error> getErrorByCode(String errorCode);	
	
	public void insertError(String errorCode, String errorDescription);

}
