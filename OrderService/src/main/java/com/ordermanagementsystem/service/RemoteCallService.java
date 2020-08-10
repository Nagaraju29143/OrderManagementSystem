package com.ordermanagementsystem.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ordermanagementsystem.model.OrderItem;

@FeignClient(name="orderitem",url="http://localhost:8012")
public interface RemoteCallService {
	
	@PostMapping("/orderitem")
	String saveOrderItem( List<OrderItem> orderItem);
	
	@GetMapping("/orderitem/{orderId}")
	List<OrderItem> getOrderItemByOrderId(@PathVariable("orderId") int orderId);

}
