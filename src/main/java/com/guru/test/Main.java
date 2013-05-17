package com.guru.test;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guru.test.model.User;
import com.guru.test.services.UserService;


public class Main {

	static UserService userService;
	public static void main(String args[]){
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		
		userService = (UserService) context.getBean("userServiceImpl");

		try {
			addUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listUsers();
	}
	
	public static void addUser() throws RuntimeException {
		
		Date date = new Date();

		String username=StringUtils.deleteWhitespace("User-"+date.toString());
		
		System.out.println(">>> About to insert a user record:");
		User user = new User();
		
		user.setName(username);
		user.setUsername(StringUtils.reverse(username));
		user.setAge(33);
		
		user.setDob(DateUtils.addYears(date, -33));
		user.setAvailable(true);
		
		//when calling the service methods individually, the transaction got committed independently for
		// each method, even though each of these methods have been configured to set transaction propagation to 
		// Propagation.REQUIRED. This is because, in Spring, a transaction is created for each service method.
		// But if a service method a() calls another service method b() (in the same class or from a different class),
		// b() will be part of the same transaction as a(). But if b() was in a differnt service class, and marked
		// with propagation = REQUIRES_NEW , then b() will have its own transaction (something similar to a nested transaction).
		// For instance, if insertUser() completes, but updateAvailability() fails,
		// then all changes by insertUser() gets committed, but any changes by updateAvailability() gets rolledback.. 
		//userService.insertUser(user);
		//updateAvailability(user, false);
		
		
		// to have both insert() and update() to be part of one transaction, enclose the calls to these methods in another method
		userService.updateUserDetails(user, false);
		
		System.out.println(">>> Done inserting user record:"+user.toString());
	}
	
	
	public static void listUsers(){
		
		System.out.println(">>> About to get all users:");
		List<User> users = userService.getAllUsers();
		for(User u : users){
			System.out.println(">>>> "+u.getId()+"-"+u.getName()+"-"+u.isAvailable());
		}		
		
	}
	
	public static void updateAvailability(User user, boolean availability) throws RuntimeException{
		userService.updateAvailability(user, false);

	}
	
}
