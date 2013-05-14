package com.guru.test.jmssender;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.guru.test.Invoice;
public class SenderUsingJMSTemplate {


	public static void main(String args[]) {

		
		ApplicationContext context =
		        new ClassPathXmlApplicationContext("beans.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		
		
		SimpleJMSSender sender = new SimpleJMSSenderImpl();
		sender.sendMessage(jmsTemplate);
		
		Invoice invoice = new Invoice();
		invoice.setCustomerName("Guru");
		invoice.setInvoiceNumber(12345);
		
		sender.sendMessage(jmsTemplate,invoice);
	}
	

	
}
