package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.OrderFood;


public interface OrderRepository extends JpaRepository<OrderFood, Integer>{

}
