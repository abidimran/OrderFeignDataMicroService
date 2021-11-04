package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.OrderFood;
import com.example.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {


	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/ping")
	public ResponseEntity<String> Ping() {

		System.out.println("Coming for Order Ping");
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}

	@GetMapping("/all-orders")
	public ResponseEntity<?> getAllOrderDetails(){

		List<OrderFood> orders = orderService.getAllOrderDetails();
		if(orders.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body("No Order Details Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<?> getOrder(@PathVariable("orderId") Integer orderId){
		try {
			OrderFood orderFood =orderService.getOrderDetails(orderId);
			return ResponseEntity.status(HttpStatus.OK).body(orderFood);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("No Order Detail Found");
		}
	}

	@PostMapping("/order")
	public ResponseEntity<List<OrderFood>> creatingOrder(@RequestBody OrderFood orderFood){
		System.out.println("OrderName: "+orderFood.getOrderName()+ 
				" OrderPrice: "+orderFood.getOrderPrice()+
				" OrderDeliveryStatus: "+orderFood.getOrderDeliveryStatus()+ 
				" OrderPaymentStatus: "+orderFood.getOrderPaymentStatus()+ 
				" OrderQuantity: "+orderFood.getOrderQuantity()+ 
				" OrderDate: "+orderFood.getOrderDate());
		orderService.saveOrder(orderFood);
		List<OrderFood> orders = orderService.getAllOrderDetails();
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}

	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable("orderId") Integer orderId){
		try {
			orderService.deleteOrder(orderId);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("No Order Detail Found");
		}
	}

	@PutMapping("/order")
	public ResponseEntity<?> updateOrder(@RequestBody OrderFood orderFood){
		try {
			orderService.updateOrder(orderFood);
			orderFood =orderService.getOrderDetails(orderFood.getOrderId());
			return ResponseEntity.status(HttpStatus.OK).body(orderFood);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("No Order Detail Found");
		}

	}


}
