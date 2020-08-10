package com.ordermanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagementsystem.entity.Order;
import com.ordermanagementsystem.exception.DaoException;
import com.ordermanagementsystem.exception.OrderNotFoundException;
import com.ordermanagementsystem.model.OrderInfo;
import com.ordermanagementsystem.model.OrderItem;
import com.ordermanagementsystem.model.OrderRequest;
import com.ordermanagementsystem.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RemoteCallService remoteCallService;

	@Override
	public void saveOrder(OrderRequest orderReq) {
		
		try {
			List<OrderItem> orderItemList=orderReq.getOrderItem();
			double total=0.0;
			for(OrderItem orderItem:orderItemList) {
				total=total+(orderItem.getPrice()*orderItem.getQuantity());
			}
			
			Order order=new Order(orderReq.getCustomerName(),orderReq.getOrderDate(),orderReq.getAddress(),total);
			Order savedOrder=orderRepository.save(order);
			
			List<OrderItem> orderItems=new ArrayList<>();
			
			for(OrderItem orderItem:orderItemList) {
				orderItem.setOrderId(savedOrder.getId());
				orderItems.add(orderItem);
			}
			
			remoteCallService.saveOrderItem(orderItems);
			
		} catch (Exception ex) {
			throw new DaoException("error occured while saving order ",ex) ;
		}
		
	}

	@Override
	public OrderInfo getOrderInfo(int orderId) {
		List<OrderItem> orderItemList=null;
		OrderInfo orderInfo=null;
		
		try {
			Order order=orderRepository.findById(orderId).get();
			orderItemList=remoteCallService.getOrderItemByOrderId(order.getId());
			orderInfo=new OrderInfo(order,orderItemList);
		
			
		}catch(Exception ex) {
			throw new DaoException("error occured while fetching order details",ex) ;
		}
		
		if(orderInfo==null) {
			throw new OrderNotFoundException("Order not found.") ;
		}
		
		return orderInfo;
	}

}
