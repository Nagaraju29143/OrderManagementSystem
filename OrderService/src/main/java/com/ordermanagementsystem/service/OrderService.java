package com.ordermanagementsystem.service;

import com.ordermanagementsystem.model.OrderRequest;
import com.ordermanagementsystem.model.OrderInfo;

public interface OrderService {
	
	void saveOrder(OrderRequest orderReq);
	
	OrderInfo getOrderInfo(int orderId);

}
