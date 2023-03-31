package com.masai.service;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.CurrentSession;
import com.masai.model.Customer;
import com.masai.repository.CurrentUserDao;
import com.masai.repository.CustomerDao;
@Service
public class CustomerServiceIpml implements CustomerService{
	@Autowired
	private CustomerDao dao;
	
	@Autowired
	private CurrentUserDao cuu;
	
	
	@Override
	public Customer addCustomer(Customer coustomer) {
		
		Customer existingCustomer = dao.findByEmail(coustomer.getEmail());
		if (existingCustomer != null)
			throw new CustomerException("Customer Already Registered with Email...!");

		Customer cu = dao.save(coustomer);
		return cu;
	}


	@Override
	public Customer updateCoustomer(Customer customer, String key) throws CustomerException, LoginException {
		CurrentSession cu = cuu.findByUuid(key);
		if(cu == null) throw new LoginException("Please Login first !");
		
		Optional<Customer> curentUser = dao.findById(customer.getCustomerId());
		if(curentUser.isEmpty()) throw new  CustomerException("Customer does not exist");
		
		return dao.save(customer);
	}


	@Override
	public Customer removeCustomer(Customer customer, String key) throws CustomerException, LoginException {
		CurrentSession cu = cuu.findByUuid(key);
		if(cu == null) throw new LoginException("Please Login first !");
		
		Optional<Customer> curentUser = dao.findById(customer.getCustomerId());
		if(curentUser.isEmpty()) throw new  CustomerException("Customer does not exist");
		
		 dao.deleteById(customer.getCustomerId());
		 
		 return curentUser.get();
	}


	@Override
	public Customer veiwCustomerById(Integer customerId, String key) throws CustomerException, LoginException {
		
		CurrentSession cu = cuu.findByUuid(key);
		if(cu == null) throw new LoginException("Please Login first !");
		
		Optional<Customer> curentUser = dao.findById(customerId);
		if(curentUser.isEmpty()) throw new  CustomerException("Customer does not exist");
		
		return curentUser.get();
	}

}
