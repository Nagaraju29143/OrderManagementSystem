package com.ordermanagementsystem.model;

import java.util.List;

import com.ordermanagementsystem.entity.Order;

public class OrderInfo {
	
	private Order order;
	private List<OrderItem> orderItems;
	
	public OrderInfo() {
		
	}

	public OrderInfo(Order order, List<OrderItem> orderItems) {
		this.order = order;
		this.orderItems = orderItems;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	

}
