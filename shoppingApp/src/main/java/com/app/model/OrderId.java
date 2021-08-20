package com.app.model;

public class OrderId {

	private String customerName;
	private String customerEmail;
	private Order order;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
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
		this.customerEmail = customerEmail;
	}
	@Override
	public String toString() {
		System.out.println("---------------------------------------------------------------------------------");
		return ", "+order.toSTring() + ", CustomerName=" + customerName + ", CustomerEmail="
				+ customerEmail ;
	}
	

}
