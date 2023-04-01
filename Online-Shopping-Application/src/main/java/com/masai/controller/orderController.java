package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.OrderService;

@RestController
public class orderController {

	@Autowired
    private OrderService orderService;
	
	
	
	 public ResponseEntity<Order> addOrderHandler(@RequestBody Order order){
		 
		 
	 }
	
	
}
