package com.masai.controller;

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
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.service.CustomerService;
import com.masai.service.LogInService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService cSer;

	private LogInService logService;

	private CurrentUserSession cs;

	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomerHandler(@Valid @RequestBody Customer customer)
			throws CustomerException, UserException {
		customer.setRole("customer");
		Customer savedcustomer = cSer.addCustomer(customer);
		return new ResponseEntity<>(savedcustomer, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<Customer> deleteCustomerHandler(@RequestParam Integer id,@RequestParam String uuid)
			throws LoginException, CustomerException, UserException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");
		Customer deletedCustomer = cSer.removeCustomer(id,uuid);

		return new ResponseEntity<>(deletedCustomer, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer, @RequestParam String uuid)
			throws CustomerException, LoginException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");
		Customer updatedCustomer;
		if (cs.getUserId().equals(customer.getCustomerId()))
			updatedCustomer = cSer.updateCustomer(customer);
		else
			throw new CustomerException("You are not allowed to update the user Id...!");

		return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);
	}


	@GetMapping("/viewCustomer")
	public ResponseEntity<Customer> viewCustomerHandler(@RequestParam String uuid)
			throws LoginException, CustomerException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		Integer customerId = cs.getUserId();

		Customer viewCustomer = cSer.viewCustomer(customerId);

		return new ResponseEntity<>(viewCustomer, HttpStatus.OK);
	}

	@Autowired
	public void setcSer(CustomerService cSer) {
		this.cSer = cSer;
	}

	@Autowired
	public void setLogService(LogInService logService) {
		this.logService = logService;
	}

	public void setCs(CurrentUserSession cs) {
		this.cs = cs;
	}

}
