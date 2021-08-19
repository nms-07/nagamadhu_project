package com.app.model;

public class Customer {

	private int customerId;
	private String customerName;
	private String customerEmail;
	private String customerPassword;
	
	
	
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail ;
	}
	
//	public int getOrderId() {
//		return orderId;
//	}
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
	@Override
	public String toString() {
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		return "Customer customerId=" +customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + "";
		
	}
	
	

	
	
	
	

}
