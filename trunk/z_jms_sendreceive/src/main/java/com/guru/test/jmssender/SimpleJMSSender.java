package com.guru.test.jmssender;
import org.springframework.jms.core.JmsTemplate;

import com.guru.test.Invoice;


public interface SimpleJMSSender {

	public void sendMessage(JmsTemplate jmsTemplate);
	public void sendMessage(JmsTemplate jmsTemplate, Invoice invoice);
}
