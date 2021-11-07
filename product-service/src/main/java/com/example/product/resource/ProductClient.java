package com.example.product.resource;

import javax.ws.rs.core.MediaType;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.product.entity.Product;

import feign.Headers;

@FeignClient(name = "product-client", url = "${product.api.url}")
public interface ProductClient {

    @Headers("Content-Type: application/json; charset=utf-8")
    @RequestMapping(value = "/api/products/{productCode}", method = RequestMethod.GET)
    Product findProduct(@PathVariable(value = "productCode") String productCode);

    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN)
    String pingProduct();

}