package com.guru.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guru.test.model.Book;
import com.guru.test.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Transactional
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<Book> findBooksByPublisher(String publisherName) {
		// TODO Auto-generated method stub
		return null;
	}

}
