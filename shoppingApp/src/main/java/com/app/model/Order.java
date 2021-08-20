package com.app.model;

public class Order {

	private int orderId;
	private int customerId;
	private int productId;
	private String orderStatus;
	private Product product;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		System.out.println("-------------------------------------------------------------------------------------");
		return "Order orderId=" + orderId + ", customerId=" + customerId + ", productId=" + productId
				+ ", orderStatus=" + orderStatus +  product.toSTring() + "";
	}
	
	
	public String toSTring() {
		return "OrderId=" + orderId + ",CustomerId=" + customerId;
	}
	
	
	
	
	

}
