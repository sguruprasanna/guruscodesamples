package com.guru.test.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guru.test.dao.LibraryDao;
import com.guru.test.model.Book;

@Service
public class LibraryDaoHibernate implements LibraryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Book> findAllBooks() {

		List<Book> allBooks = new ArrayList<Book>();
		
		allBooks = sessionFactory.getCurrentSession().createCriteria(Book.class).list();
		
		return allBooks;
		
		
	}

	@Transactional(propagation=Propagation.MANDATORY)
	public List<Book> findBooksByPublisher(String publisherName) {
		// TODO Auto-generated method stub
		return null;
	}

}
