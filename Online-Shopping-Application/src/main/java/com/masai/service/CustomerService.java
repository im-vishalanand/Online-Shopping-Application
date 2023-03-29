package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	public Customer addCoustomer(Customer coustomer);
	
	public Customer updateCoustomer(Customer customer, String key) throws CustomerException,LoginException;
	
	public  Customer removeCustomer(Customer customer, String key) throws CustomerException,LoginException;
	
	public Customer veiwCustomerById(Integer customerId, String key) throws CustomerException,LoginException;
}
