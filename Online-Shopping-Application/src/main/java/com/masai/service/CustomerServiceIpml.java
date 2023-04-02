package com.masai.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.repository.CurrentSessionDao;
import com.masai.repository.CustomerDao;
@Service
public class CustomerServiceIpml implements CustomerService{
	
	
	@Autowired
	private CustomerDao dao;
	
	@Autowired
	private CurrentSessionDao cuu;
	
	
	@Override
	public Customer addCustomer(Customer customer) {
		
		Customer existingCustomer = dao.findByEmail(customer.getEmail());
		
		if (existingCustomer != null) {
			
			throw new CustomerException("Customer Already Registered with Email...!");
		
		}
		
		List<Orders> listOfOrders = customer.getListOfOrders();
		
		for(Orders order:listOfOrders) {
			
			order.setCustomer(existingCustomer);
			
		}

		Customer cu = dao.save(customer);
		return cu;
	}


	@Override
	public Customer updateCoustomer(Customer customer) throws CustomerException, LoginException {
//		CurrentSession cu = cuu.findByUuid(key);
		Optional<Customer> cu= dao.findById(customer.getCustomerId());
		if(cu == null) throw new LoginException("Please Login first !");
		
		Optional<Customer> curentUser = dao.findById(customer.getCustomerId());
		if(curentUser.isEmpty()) throw new  CustomerException("Customer does not exist");
		
		return dao.save(customer);
	}


	@Override
	public Customer removeCustomer(Integer customerId) throws CustomerException, LoginException {
		
		Optional<Customer> opt= dao.findById(customerId);
		
		if(opt.isPresent()) {
						
			Customer cust=opt.get();
			
			dao.delete(cust);
			
			return cust;
			
		}
		
		else {
			
			throw new CustomerException("Customer not present for given customer Id: "+customerId);
			
		}
	}


	@Override
	public Customer viewCustomerById(Integer customerId) throws CustomerException, LoginException {
		
		Optional<Customer> opt= dao.findById(customerId);
		
		if(opt.isPresent()) {
						
			Customer cust=opt.get();
						
			return cust;
			
		}
		
		else {
			
			throw new CustomerException("Customer not present for given customer Id: "+customerId);
			
		}
	}


	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
		
		List<Customer> customerList= dao.findAll();
		
		if(customerList.isEmpty()) {
			
			throw new CustomerException("No customer found");
			
		}
		
		else {
			
			return customerList;
			
		}
		
	}


}
