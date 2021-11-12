package com.example.resources;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Delivery;

import feign.Headers;

@FeignClient(value = "delivery-Client", url = "${delivery.api.url}")
@Headers("Content-Type : application/json")
public interface DeliveryClient {

	@RequestMapping(value = "/delivery", method = RequestMethod.POST)
	Delivery createDelivery (@RequestBody Delivery delivery);
	
	
}
