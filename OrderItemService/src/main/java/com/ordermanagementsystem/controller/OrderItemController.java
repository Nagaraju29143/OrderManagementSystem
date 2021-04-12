package com.ordermanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagementsystem.entity.OrderItem;
import com.ordermanagementsystem.model.OrderItemRequest;
import com.ordermanagementsystem.service.OrderItemService;

@RestController
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService;
	
	@PostMapping("/orderitem")
	public ResponseEntity<String> saveOrderItem(@RequestBody List<OrderItemRequest> orderItemReq) {
		
		System.out.println("in OrderItemController:saveOrderItem: "+orderItemReq);
		
		orderItemService.saveOrderItem(orderItemReq);
		
		return new ResponseEntity("orderitem saved",HttpStatus.OK);
	}
	
	@GetMapping("/orderitem/{orderId}")
	public ResponseEntity<List<OrderItem>> getOrderItemByOrderId(@PathVariable("orderId") int orderId) {
		
		System.out.println("in OrderItemController:getOrderItemByOrderId "+orderId);
		
		List<OrderItem> orderItemList=orderItemService.getOrderItemByOrderId(orderId);
		System.out.println("orderItemList::"+orderItemList);
		
		return new ResponseEntity<List<OrderItem>>(orderItemList,HttpStatus.OK);
	}


}
