package com.lps.test.webservice;

import javax.jws.WebService;

@WebService(endpointInterface="com.lps.test.webservice.TestWebservice")
public class TestWebserviceImpl implements TestWebservice {
	

	@Override
	public String checkLoanStatus(String loanNumber) {
		return "Loan:"+loanNumber+" is active.";
	}

}
