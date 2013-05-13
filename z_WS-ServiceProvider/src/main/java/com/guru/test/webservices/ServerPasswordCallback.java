package com.guru.test.webservices;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class ServerPasswordCallback implements CallbackHandler {

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {

		for(Callback callback : callbacks){
			
			WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callback;

			// below block is used only for usernametoken based authentication...
			/*if(wsPasswordCallback.getUsage() == WSPasswordCallback.USERNAME_TOKEN){
				
				if(wsPasswordCallback.getIdentifier().equalsIgnoreCase("guru")){
					wsPasswordCallback.setPassword("password");
				}
			}*/
			
			
			if( (wsPasswordCallback.getUsage() == WSPasswordCallback.SIGNATURE)
					|| (wsPasswordCallback.getUsage() == WSPasswordCallback.DECRYPT)
			){
			
				if(wsPasswordCallback.getIdentifier().equalsIgnoreCase("server")){
					wsPasswordCallback.setPassword("changeme");
				}
			}
		}
	}
}
