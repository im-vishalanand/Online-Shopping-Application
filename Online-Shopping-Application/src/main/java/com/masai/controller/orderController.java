package com.masai.controller;

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
