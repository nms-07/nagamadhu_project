package com.app.model;

public class Product {

	private int id;
	private String name;
	private String manufacturer;
	private double cost;
	
//	public Product(int id,String name,String manufacturer,double cost) {
//		this.id = id;
//		this.name = name;
//		this.manufacturer = manufacturer;
//		this.cost = cost;
//	}
	
	public Product(int productId, String productName, String manufacturer2, double productCost) {
	}



	public Product() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "-------------Product [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", cost=" + cost + "]\n";
	}

}
