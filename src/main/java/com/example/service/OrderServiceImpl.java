package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.OrderFood;
import com.example.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService{

	private OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<OrderFood> getAllOrderDetails() {
		return orderRepository.findAll();
	}

	public OrderFood getOrderDetails(Integer orderId) {
		
		return orderRepository.getById(orderId);
	}

	public OrderFood saveOrder(OrderFood order) {
		return orderRepository.save(order);
	}

	public OrderFood updateOrder(OrderFood order) {
		
		OrderFood food = OrderFood.builder().orderId(order.getOrderId()).orderDate(order.getOrderDate()).orderDeliveryStatus(order.getOrderDeliveryStatus())
				.orderName(order.getOrderName()).orderPaymentStatus(order.getOrderPaymentStatus()).
				orderPrice(order.getOrderPrice()).orderQuantity(order.getOrderQuantity()).build();
				
		
		return orderRepository.save(food);
	}

	public void deleteOrder(Integer orderId) {
		orderRepository.deleteById(orderId);
	}

}
