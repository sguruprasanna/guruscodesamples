package com.guru.test.webservices;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class ClientPasswordCallback implements CallbackHandler {

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		
		 for (int i = 0; i < callbacks.length; i++) {

			 WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];

			 // below block is used only for usernametoken based authentication
			 /*if (pc.getUsage() == WSPasswordCallback.USERNAME_TOKEN) {
			 
			 //you can source the username and password from 
			 //other sources like login context, LDAP, DB etc

				 pc.setIdentifier("guru");
				 pc.setPassword("password");
			 }*/
			 
			if( (pc.getUsage() == WSPasswordCallback.SIGNATURE)
					|| (pc.getUsage() == WSPasswordCallback.DECRYPT)
			){
			
				if(pc.getIdentifier().equalsIgnoreCase("client")){
					pc.setPassword("changeme");
				}
			}			 
			 
		 }
	}


}
