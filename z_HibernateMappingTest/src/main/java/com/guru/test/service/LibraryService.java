package com.guru.test.service;

import java.util.List;

import com.guru.test.model.Book;


public interface LibraryService {

	
	public List<Book> findAllBooks();
	public List<Book> findBooksByPublisher(String publisherName);
}
