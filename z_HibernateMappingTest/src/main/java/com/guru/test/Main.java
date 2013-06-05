package com.guru.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guru.test.model.Book;
import com.guru.test.service.LibraryService;

public class Main {

	
	public static void main(String... args){
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		
		LibraryService libraryService = (LibraryService) context.getBean("libraryServiceImpl");

		List<Book> books = libraryService.findAllBooks();
		
		for(Book book : books){
			System.out.println(book.toString());
		}
	}
	
}
