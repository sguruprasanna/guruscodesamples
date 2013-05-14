package com.guru.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.commons.lang3.StringUtils;

import com.guru.test.model.User;
import com.guru.test.services.UserService;

public class Main {

	public static void main(String args[]){
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		
		UserService userService = (UserService) context.getBean("userServiceImpl");
		
		
		Date date = new Date();
		String username=StringUtils.deleteWhitespace("User-"+date.toString());
		
		System.out.println(">>> About to insert a user record:");
		User user = new User();
		user.setName(username);
		user.setUsername(StringUtils.reverse(username));
		userService.insertUser(user);
		System.out.println(">>> Done inserting user record:"+user.toString());
		
		
		System.out.println(">>> About to get all users:");
		List<User> users = userService.getAllUsers();
		for(User u : users){
			System.out.println(">>>> "+u.getId()+"-"+u.getName());
		}
	}
	
}
