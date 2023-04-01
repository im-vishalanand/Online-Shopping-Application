package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> addCustomerHandler( @RequestBody Customer customer)  {
		Customer savedcustomer = customerService.addCustomer(customer);
		return new ResponseEntity<>(savedcustomer, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Customer> updateCoustomerHandler( @RequestBody Customer customer, String key)  {

		customerService.updateCoustomer(customer, key);
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	{
//	    "firstName":"firstName",
//	    "lastName":"lastName",
//	    "mobileNumber":"121231231233",
//	    "password":"password12",
//	    "address":{
//	        "streetName":"streetName",
//	        "buildingName":"buildingName",
//	        "city":"city",
//	        "state":"state",
//	        "pincode":"pincode",
//	        "country":"country"
//	    },
//	    "email":"email@mail.com"
//	}
	
	
	
}
