package com.guru.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guru.test.dao.UserDao;
import com.guru.test.model.User;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}

	public void insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public User getUserById(int userId) {
		return null;
	}

	public User getUser(String username) {
		return null;
	}

}
