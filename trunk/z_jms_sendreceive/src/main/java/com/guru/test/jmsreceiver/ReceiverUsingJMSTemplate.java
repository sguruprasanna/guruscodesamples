package com.guru.test.jmsreceiver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class ReceiverUsingJMSTemplate {

	
	public static void main(String args[]){
		
		
		ApplicationContext context =
		        new ClassPathXmlApplicationContext("receiver-beans.xml");
	}
}
