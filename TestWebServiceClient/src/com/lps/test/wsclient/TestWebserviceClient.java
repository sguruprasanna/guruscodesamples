package com.lps.test.wsclient;

import com.lps.test.webservice.TestWebservice;
import com.lps.test.webservice.TestWebserviceImplService;

public class TestWebserviceClient {

	public static void main(String[] args) {
		TestWebserviceImplService testService = new TestWebserviceImplService();
		TestWebservice ws = testService.getTestWebserviceImplPort();
		System.out.println(">>>>>>>>>>> got this as result:["+ws.checkLoanStatus("1234")+"]");
		
	}
}