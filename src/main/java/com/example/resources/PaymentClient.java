package com.example.resources;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Payment;

import feign.Headers;

@FeignClient(value = "payment-client", url = "${payment.api.url}")
@Headers("Content-Type : application/json")
public interface PaymentClient {

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	Payment createPayment (@RequestBody Payment payment);
	
	
}
