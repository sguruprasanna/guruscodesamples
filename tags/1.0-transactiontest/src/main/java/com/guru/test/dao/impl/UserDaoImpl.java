package com.guru.test.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guru.test.dao.UserDao;
import com.guru.test.model.User;

import com.guru.test.model.Error;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.MANDATORY)
	public List<User> getAllUsers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}

	@Transactional(propagation=Propagation.MANDATORY)
	public void insertUser(User user) {
		
		System.out.println(">>>>>>"+sessionFactory.getCurrentSession().getTransaction().hashCode());
		sessionFactory.getCurrentSession().save(user);
	}

	@Transactional(propagation=Propagation.MANDATORY)
	public User getUserById(int userId) {
		return null;
	}

	@Transactional(propagation=Propagation.MANDATORY)
	public User getUser(String username) {
		return null;
	}
	
	@Transactional(propagation=Propagation.MANDATORY)
	public void updateAvailability(User user, boolean available) {
		
		System.out.println(">>>>>> txId in updateAvailability() "+sessionFactory.getCurrentSession().getTransaction().hashCode());
		try {
			user.setAvailable(available);
			//throw new RuntimeException();
			sessionFactory.getCurrentSession().saveOrUpdate(null);
		} catch(RuntimeException e){
			
			// if exception is handled in DAO layer, the transaction gets committed. In this case,
			// the user gets inserted, and after exception occurs, error record also gets inserted. 
			
			//commenting out the code, and rethrowing excepion to see if roll back occurs...
			//System.out.println(">>> Exception occured...");
			//e.printStackTrace();
			//updateError("USER_AVAIL_ERROR","Error updating user availability...");
			throw e;
		}
		
		//sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	

/*	//@Transactional(propagation=Propagation.MANDATORY)
	public void updateAvailability(User user, boolean available) {
		
		Session s = sessionFactory.openSession();

		// new transaction
		s.beginTransaction().begin();
		
		System.out.println(">>>>>> new transaction : "+s.getTransaction().hashCode());

		
		user.setAvailable(available);
		
		// intentionally setting id to 1 to cause unique constraint error.
		user.setId(1);
		
		try{
			s.saveOrUpdate(user);
			s.getTransaction().commit();
			
			System.out.println(">>>> Transaction "+s.getTransaction().hashCode()+" comitted successfully.");
			
		}catch(Exception e){

			s.getTransaction().rollback();
			System.out.println(">>>> Transaction "+s.getTransaction().hashCode()+" rolled back successfully.");
		}
		
		
		
	}
*/	
	

}
