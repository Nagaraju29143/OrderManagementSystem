package com.ordermanagementsystem.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagementsystem.model.OrderInfo;
import com.ordermanagementsystem.model.OrderRequest;
import com.ordermanagementsystem.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public ResponseEntity<String> saveOrder(@RequestBody OrderRequest order) {
		
		System.out.println("in OrderController:saveUser"+order);
		
		
		orderService.saveOrder(order);
		
		return new ResponseEntity<String>("order saved",HttpStatus.OK);
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<OrderInfo> getOrderInfoById(@PathVariable("orderId") int orderId) {
		
		System.out.println("in OrderItemController:getOrderItem"+orderId);
		
		return new ResponseEntity<OrderInfo>(orderService.getOrderInfo(orderId),HttpStatus.OK);
	}
	

}
