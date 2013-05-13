/**
 * 
 */
package com.guru.test.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author subbagu
 *
 */

@WebService(endpointInterface="com.guru.test.webservices.EchoService")
public class EchoServiceImpl implements EchoService {

	/* (non-Javadoc)
	 * @see com.guru.test.webservices.EchoService#echo(java.lang.String)
	 */
	public String echo(String message) {
		
		return ">>you said: "+message;
	}

}
