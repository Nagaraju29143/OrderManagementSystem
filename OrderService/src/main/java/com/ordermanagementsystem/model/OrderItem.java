package com.ordermanagementsystem.model;

public class OrderItem {
	
	private int orderId;
	private String productCode;
	private String productName;
	private int quantity;
	private double price;
	
	public OrderItem() {
		
	}

	public OrderItem(int orderId, String productCode, String productName, int quantity, double price) {
		super();
		this.orderId = orderId;
		this.productCode = productCode;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderItem [orderId=" + orderId + ", productCode=" + productCode + ", productName=" + productName
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
