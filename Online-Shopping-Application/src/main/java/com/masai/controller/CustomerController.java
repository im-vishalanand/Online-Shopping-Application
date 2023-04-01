package com.masai.controller;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/addCustomer")
	public ResponseEntity<Customer> addCustomerController(@Valid @RequestBody Customer customer){
		
		Customer savedCustomer= customerService.addCustomer(customer);
		
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/updateCustomer")
	public ResponseEntity<Customer> updateCustomerController(@Valid @RequestBody Customer customer) throws CustomerException, LoginException{
		
		Customer updatedCustomer= customerService.updateCoustomer(customer);
		
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
		
	}
	@PutMapping
	public ResponseEntity<Customer> updateCoustomerHandler( @RequestBody Customer customer) throws CustomerException, LoginException  {

		Customer existingcustomer = customerService.updateCoustomer(customer);
	
		return new ResponseEntity<>(existingcustomer, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping
	public ResponseEntity<Customer> removeCustomerIdHandler(@RequestParam Integer customerId) throws CustomerException, LoginException  {

		Customer existingcustomer = customerService.removeCustomer(customerId);
		
		return new ResponseEntity<>(existingcustomer, HttpStatus.ACCEPTED);
	
	}
	
	
	
	@GetMapping
	public ResponseEntity<Customer> veiwCustomerByIdHandler(@RequestParam Integer customerId) throws CustomerException, LoginException  {
		
		
		Customer existingcustomer = customerService.viewCustomerById(customerId);
		
		return new ResponseEntity<>(existingcustomer, HttpStatus.OK);
	}
		
	@DeleteMapping(value = "/deleteCustomer")
	public ResponseEntity<Customer> removeCustomerController(@Valid @RequestParam Integer customerId) throws CustomerException, LoginException{
		
		Customer removedCustomer= customerService.removeCustomer(customerId);
		
		return new ResponseEntity<Customer>(removedCustomer, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/ViewCustomer")
	public ResponseEntity<Customer> viewCustomerController(@Valid @RequestParam Integer customerId) throws CustomerException, LoginException{
		
		Customer fetchedCustomer= customerService.viewCustomerById(customerId);
		
		return new ResponseEntity<Customer>(fetchedCustomer, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/ViewAllCustomers")
	public ResponseEntity<List<Customer>> viewAllCustomerController(){
		
		List<Customer> customerList= customerService.viewAllCustomer();
		
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
		
	}
	
	
	
}
