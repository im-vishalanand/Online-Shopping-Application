package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.OrderService;

@RestController
public class orderController {

	@Autowired
    private OrderService orderService;
	
	
	@PostMapping("/orders/setOrder")
	 public ResponseEntity<Order> addOrderHandler(@RequestBody Order order){
		 
		 Order addedOrder = orderService.addOrder(order);
		 
		 return new ResponseEntity<>(addedOrder, HttpStatus.CREATED);
		 
	 }
	
	
}
