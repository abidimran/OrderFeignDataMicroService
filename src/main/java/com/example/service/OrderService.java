package com.example.service;

import java.util.List;

import com.example.model.OrderFood;

public interface OrderService {
	
	
	public List<OrderFood> getAllOrderDetails();
	public OrderFood getOrderDetails(Integer orderId);
	public OrderFood saveOrder(OrderFood order);
	public OrderFood updateOrder(OrderFood order);
	public void deleteOrder(Integer orderId);
	
	

}
