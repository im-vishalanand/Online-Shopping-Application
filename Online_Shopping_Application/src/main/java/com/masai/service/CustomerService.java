package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.UserException;
import com.masai.model.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer cust) throws CustomerException, UserException;

	public Customer removeCustomer(Integer id,String uuid) throws CustomerException,UserException;

	public Customer updateCustomer(Customer cust) throws CustomerException;

	public List<Customer> ViewAllCustomers(String location) throws CustomerException;

	public Customer viewCustomer(Integer customerId) throws CustomerException;
}
