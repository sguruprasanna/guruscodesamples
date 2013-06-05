package com.guru.test.dao;

import java.util.List;

import com.guru.test.model.Book;


public interface LibraryDao {
	
	public List<Book> findAllBooks();
	public List<Book> findBooksByPublisher(String publisherName);

}
