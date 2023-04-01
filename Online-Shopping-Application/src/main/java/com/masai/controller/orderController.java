package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Orders;
import com.masai.service.OrderService;

@RestController
@RequestMapping("/orders")
public class orderController {

	@Autowired
    private OrderService orderService;
	
	
	@PostMapping
	 public ResponseEntity<Orders> addOrderHandler(@RequestBody Orders order){
		 
		 Orders addedOrder = orderService.addOrder(order);
		 
		 return new ResponseEntity<>(addedOrder, HttpStatus.CREATED);
		 
	 }
	
	
	
	@PutMapping
	 public ResponseEntity<Orders> updateOrderHandler(@RequestBody Orders order){

	 
		 Orders updateOrder = orderService.updateOrder(order);
	 
		 return new ResponseEntity<>(updateOrder, HttpStatus.ACCEPTED);

	 }
	 
	 
	 
	 
	 public ResponseEntity<Orders> removeOrderHandler(Orders order){
		 
		 Orders orderRemove = orderService.removeOrder(order);

		 
		 
		 
	 }
	 
	 
	 
	 
	 
	 
}
