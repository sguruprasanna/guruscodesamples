package com.guru.test;

public class InvoiceProcessorImpl implements InvoiceProcessor{

	public void processInvoice(String invoiceNumber) {

		System.out.println(">>> Processed invoice: "+invoiceNumber);
	}

	
	public void processInvoice(Invoice invoice) {

		System.out.println(">>> Processed invoice: "+invoice.getInvoiceNumber());
	}
}
