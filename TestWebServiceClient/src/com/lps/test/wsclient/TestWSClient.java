package com.lps.test.wsclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.handler.MessageContext;

import com.lps.test.webservice.TestWebservice;
import com.lps.test.webservice.TestWebserviceImplService;;

@WebServiceRef(TestWebserviceImplService.class)
public class TestWSClient {

	public static void main(String[] args) {
		
		
		URL url;
		try {
/*			url = new URL("http://localhost:8888/services/TestWebservice?wsdl");
			
	        QName qname = new QName("http://webservice.test.lps.com/", "TestWebserviceImplService");
	        Service service = Service.create(url, qname);
	        
	        Map<String, Object> req_ctx = ((BindingProvider) service).getRequestContext();
	        req_ctx.put(
					MessageContext.HTTP_REQUEST_HEADERS,
					Collections.singletonMap("User_Company",
							Collections.singletonList("SalesEdge")));
	         
	        TestWebservice ws = service.getPort(TestWebservice.class);
	        System.out.println(ws.checkLoanStatus("12345"));
*/	   
			
			
/*	        Service service = Service.create(new URL("http://localhost:8080/services/TestWebservice?wsdl"), new QName("http://webservice.test.lps.com/", "TestWebserviceImplService")); 
	        BindingProvider port = (BindingProvider) service.getPort(new QName("http://webservice.test.lps.com/", "TestWebserviceImplPort"), TestWebservice.class); 
	        */
	        
			
			url = new URL("http://localhost:8888/services/TestWebservice?wsdl");
	        QName qname = new QName("http://webservice.test.lps.com/", "TestWebserviceImplService");
	        Service service = Service.create(url, qname);

	        TestWebservice ws = service.getPort(TestWebservice.class);
	        
	        Map<String, Object> req_ctx = ((BindingProvider)ws).getRequestContext();
	        
	        // Set up the Map that will contain the request headers.
	        Map<String, Object> requestHeaders = new HashMap<String, Object>();
	        requestHeaders.put("MyHeader1", Collections.singletonList("TEST-HEADER-VALUE"));
	        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
	        
	        System.out.println(ws.checkLoanStatus("1234"));
	        
	        
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
