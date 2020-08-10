package com.ordermanagementsystem.service;

import java.util.List;

import com.ordermanagementsystem.entity.OrderItem;
import com.ordermanagementsystem.model.OrderItemRequest;

public interface OrderItemService {
	
	void saveOrderItem(List<OrderItemRequest> orderItem);
	
	List<OrderItem> getOrderItemByOrderId(int orderId);

}
