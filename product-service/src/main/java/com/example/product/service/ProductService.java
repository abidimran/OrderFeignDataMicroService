package com.example.product.service;

import org.springframework.stereotype.Service;

import com.example.product.entity.Product;
import com.example.product.resource.ProductClient;

@Service
public class ProductService {

    private ProductClient productClient;

    public ProductService(final ProductClient productClient) {
        this.productClient = productClient;
    }

    public Product find(final String productId) {

        try {

            return productClient.findProduct(productId);
        } catch (final Exception e) {
            return null;
        }
    }

    public String pingProduct(final String msisdn) {

        return productClient.pingProduct();
    }

}
