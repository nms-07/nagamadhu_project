package com.app.model;

public class Cart {

	//private int serialNumber;
	private int productId;
	private int customerId;
	private Product product;
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		System.out.println("--------------------------------------------------------------------------------------");
		return "Cart productId=" + productId + ", customerId=" + customerId + ","+ product.toSTring() + "";
	}
	
	
	
	

}
