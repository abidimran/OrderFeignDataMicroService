package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Delivery;
import com.example.model.OrderFood;
import com.example.model.Payment;
import com.example.repository.OrderRepository;
import com.example.resources.DeliveryClient;
import com.example.resources.PaymentClient;


@Service
public class OrderServiceImpl implements OrderService{

	private OrderRepository orderRepository;
	
	private PaymentClient paymentClient;
	private DeliveryClient deliveryClient;
	
	private final static String INITIAL_PAYMENT_STATUS = "CREATED";
	private final static String INITIAL_DELIVERY_STATUS = "CREATED";

	

	public OrderServiceImpl(OrderRepository orderRepository, PaymentClient paymentClient,
			DeliveryClient deliveryClient) {
		this.orderRepository = orderRepository;
		this.paymentClient = paymentClient;
		this.deliveryClient = deliveryClient;
	}

	public List<OrderFood> getAllOrderDetails() {
		return orderRepository.findAll();
	}

	public OrderFood getOrderDetails(Integer orderId) {
		
		return orderRepository.getById(orderId);
	}

	public OrderFood saveOrder(OrderFood order) {
		OrderFood food = orderRepository.save(order);
		Payment paymentData = Payment.builder().orderId(food.getOrderId()).paymentDate(new Date()).paymentStatus(INITIAL_PAYMENT_STATUS).build();
		Payment payment = paymentClient.createPayment(paymentData);
		Delivery deliveryData = Delivery.builder().deliveryDate(new Date()).deliveryRiderName("ABC").deliveryStatus(INITIAL_DELIVERY_STATUS)
				.orderId(food.getOrderId()).build();
		Delivery delivery = deliveryClient.createDelivery(deliveryData);
		food.setDeliveryId(delivery.getDeliveryId());
		food.setPaymentId(payment.getPaymentId());
		updateOrder(food);
		return food;
	}

	public OrderFood updateOrder(OrderFood order) {
		
		OrderFood food = OrderFood.builder().orderId(order.getOrderId()).orderDate(order.getOrderDate()).orderDeliveryStatus(order.getOrderDeliveryStatus())
				.orderName(order.getOrderName()).orderPaymentStatus(order.getOrderPaymentStatus()).
				orderPrice(order.getOrderPrice()).orderQuantity(order.getOrderQuantity())
				.paymentId(order.getPaymentId()).build();
				
		
		return orderRepository.save(food);
	}

	public void deleteOrder(Integer orderId) {
		orderRepository.deleteById(orderId);
	}

}
