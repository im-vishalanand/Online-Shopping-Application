package com.masai.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AddressException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderException;
import com.masai.exception.ProductException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Orders;
import com.masai.service.LogInService;
import com.masai.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderContoller {

	private OrderService oSer;

	private LogInService logService;

	private CurrentUserSession cs;

	@PostMapping("/addOrder")
	public ResponseEntity<Orders> addOrderHandler(@Valid @RequestBody Orders orders, @RequestParam Integer addressId,
			@RequestParam String uuid)
			throws LoginException, OrderException, CustomerException, ProductException, AddressException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		Integer customerId = cs.getUserId();

		Orders order = oSer.addOrders(orders, customerId, addressId);

		return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
	}

	@PutMapping("/returnOrder")
	public ResponseEntity<Orders> returnOrderHandler(@RequestParam Integer orderId, @RequestParam String uuid)
			throws LoginException, OrderException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		Orders order = oSer.viewOrder(orderId);
		order = oSer.removeOrder(order);

		return new ResponseEntity<>(order, HttpStatus.FOUND);
	}

	@PutMapping("/cancelOrder")
	public ResponseEntity<Orders> cancelOrderHandler(@RequestParam Integer orderId, @RequestParam String uuid)
			throws OrderException, LoginException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		Orders order = oSer.viewOrder(orderId);
		order = oSer.updateOrders(order);

		return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewAllOrder")
	public ResponseEntity<List<Orders>> viewAllOrderHandler(@RequestParam String uuid)
			throws OrderException, CustomerException, ProductException, LoginException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		Integer customerId = cs.getUserId();

		List<Orders> orders = oSer.viewAllOrdersByUserId(customerId);

		return new ResponseEntity<>(orders, HttpStatus.FOUND);
	}

	@GetMapping("/viewAllOrderByDate")
	public ResponseEntity<List<Orders>> viewAllOrderHandler(@RequestParam("dd-MM-yyyy") String date,
			@RequestParam String uuid) throws OrderException, LoginException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");

		LocalDate localDate = LocalDate.parse(date, formatter);

		List<Orders> orders = oSer.viewAllOrders(localDate);

		return new ResponseEntity<>(orders, HttpStatus.FOUND);
	}

	@GetMapping("/viewOrderById")
	public ResponseEntity<Orders> viewOrderByOrderIDHandler(@RequestParam Integer ordersId,
			@RequestParam(required = true) String uuid)
			throws OrderException, CustomerException, ProductException, LoginException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		Orders order = oSer.viewOrder(ordersId);

		return new ResponseEntity<>(order, HttpStatus.FOUND);
	}

	@Autowired
	public void setoSer(OrderService oSer) {
		this.oSer = oSer;
	}

	@Autowired
	public void setLogService(LogInService logService) {
		this.logService = logService;
	}

	public void setCs(CurrentUserSession cs) {
		this.cs = cs;
	}

}