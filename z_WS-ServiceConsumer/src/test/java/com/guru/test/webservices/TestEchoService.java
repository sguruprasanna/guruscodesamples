
package com.guru.test.webservices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:beans.xml"})

public class TestEchoService {

	@Autowired
	private EchoService echoClient; 
	
	@Test
	public void testEchoService(){
		
		assertNotNull(echoClient);
		
		//echoClient.echo("Hello");
		String message = "Hi there!";
		
		String response = echoClient.echo("Hi there!");
		System.out.println("Response - "+response);
		
		assertEquals(response, ">>you said: "+message);
	}
}
