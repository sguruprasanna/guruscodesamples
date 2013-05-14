package com.guru.test.jmssender;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.guru.test.Invoice;



public class SimpleJMSSenderImpl implements SimpleJMSSender {

	
	//@Autowired
	//private static JmsTemplate jmsTemplate;
	
	
	
	public void sendMessage(JmsTemplate jmsTemplate){
		

		//StringBuilder payload = new StringBuilder();
		//jmsTemplate.send("GURU.LOCAL",new MessageCreator(){

		jmsTemplate.send(new MessageCreator(){

			public Message createMessage(Session session) throws JMSException {

				TextMessage msg = session.createTextMessage("Hello!");
				msg.setIntProperty("MessageCount", 1);
				return msg;
			}
			
		});
		
	}
	
	public void sendMessage(JmsTemplate jmsTemplate, final Invoice invoice){
		
		jmsTemplate.send(new MessageCreator(){

			public Message createMessage(Session session) throws JMSException {

				//TextMessage msg = session.createTextMessage("Hello!");
				ObjectMessage msg = session.createObjectMessage(invoice);
				msg.setIntProperty("MessageCount", 1);
				return msg;
			}
			
		});
		
	}	
	
}
