package com.guru.test.dao.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;


import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guru.test.dao.ErrorDao;
import com.guru.test.model.Error;

@Service
public class ErrorDaoImpl implements ErrorDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public List<Error> getAllErrors() {
		return null;
	}
	
	
	@Transactional(propagation=Propagation.MANDATORY)
	public void insertError(Error error) {
		sessionFactory.getCurrentSession().save(error);
	}
	
	
	@Transactional(propagation=Propagation.MANDATORY)
	@SuppressWarnings("unchecked")
	public List<Error> getErrorByCode(String errorCode) {
		if(StringUtils.isNotEmpty(errorCode)){
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(Error.class).add(Restrictions.sqlRestriction("code="+errorCode));
			return crit.list();
		}
		
		return Collections.emptyList();
	}

	//if the propagation is set to REQUIRES_NEW, then the error record gets inserted
	// even if the outer transaction gets rolled back.
	// Any other propagation setting rolls back both outer and inner transactions.
	@Transactional(propagation=Propagation.MANDATORY)
	public void insertError(String errorCode, String errorDescription){
		System.out.println(">>>>>> txId in errordao updateError() :"+sessionFactory.getCurrentSession().getTransaction().hashCode());
		Error error = new Error();
		error.setCode(errorCode);
		error.setDescription(errorDescription);
		error.setCreatedOn(new Date());
		
		sessionFactory.getCurrentSession().save(error);
	}

}
