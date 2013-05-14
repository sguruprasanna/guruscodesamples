package com.guru.test;

import java.io.Serializable;

public class Invoice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8878167198577053393L;
	private long invoiceNumber;
	private String customerName;
	/**
	 * @return the invoiceNumber
	 */
	public long getInvoiceNumber() {
		return invoiceNumber;
	}
	/**
	 * @param invoiceNumber the invoiceNumber to set
	 */
	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}
