package com.ordermanagementsystem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderRequest {
	
	@NotEmpty(message = "customer name is required")
	@Size(max = 20, min = 3, message = "customer name should contains atleast 3 characters")
	private String customerName;
	
	@Past
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date orderDate;
	
	@NotEmpty(message = "address is required")
	private String address;
	
	@NotEmpty(message = "OrderItem is required")
    private List<OrderItem> orderItem;
    
    public OrderRequest() {
    	
    }

	public OrderRequest(String customerName, Date orderDate, String address, List<OrderItem> orderItem) {
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.address = address;
		this.orderItem = orderItem;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	@Override
	public String toString() {
		return "OrderRequest [customerName=" + customerName + ", orderDate=" + orderDate + ", address=" + address
				+ ", orderItem=" + orderItem + "]";
	}
	
    
    
}
