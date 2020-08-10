package com.ordermanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagementsystem.entity.OrderItem;
import com.ordermanagementsystem.model.OrderItemRequest;
import com.ordermanagementsystem.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	
	

	@Override
	public void saveOrderItem(List<OrderItemRequest> orderItems) {
		for(OrderItemRequest orderItemReq:orderItems) {
			
			OrderItem orderItem=new OrderItem(orderItemReq.getOrderId(),orderItemReq.getProductCode(),orderItemReq.getProductName(),orderItemReq.getQuantity(),orderItemReq.getPrice());
			orderItemRepository.save(orderItem);
		}
	}

	@Override
	public List<OrderItem> getOrderItemByOrderId(int orderId) {
		
		return orderItemRepository.findByOrderId(orderId);
	}

}
