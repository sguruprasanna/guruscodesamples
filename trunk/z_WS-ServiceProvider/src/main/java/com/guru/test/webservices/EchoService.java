package com.guru.test.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface EchoService {

	public String echo(String message);
}
