package com.masai.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer coustomer);
	
	public Customer updateCoustomer(Customer customer) throws CustomerException,LoginException;
	
	public  Customer removeCustomer(Integer customerId) throws CustomerException,LoginException;
	
	public Customer viewCustomerById(Integer customerId) throws CustomerException,LoginException;
	
	public List<Customer> viewAllCustomer() throws CustomerException;

}
