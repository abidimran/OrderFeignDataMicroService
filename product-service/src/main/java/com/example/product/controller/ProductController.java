package com.example.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/ping")
    public String ping() {
        return "Product API is Up";
    }

    @GetMapping("/find/{productId}")
    public ResponseEntity<?> find(@PathVariable("productId") final String productId) {

        final Product product = productService.find(productId);
        if(product != null) {
            return ResponseEntity.ok(product);
        }else {
            return ResponseEntity.ok("Not Available");
        }
    }

    @GetMapping("/ping/{productId}")
    public ResponseEntity<?> ping(@PathVariable("productId") final String productId) {

        final String product = productService.pingProduct(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.ok("Not Available");
        }
    }

}
