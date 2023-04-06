package com.masai.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.UserException;
import com.masai.model.Address;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo custRepo;

	
	@Autowired
	private LogInService logService;
	
	@Autowired
	private CurrentUserSessionRepo currentUserSessionRepo;
	
	
	@Override
	public Customer addCustomer(Customer cust) throws CustomerException, UserException {

		Customer existingCustomer = custRepo.findByEmail(cust.getEmail());
		if (existingCustomer != null)
			throw new CustomerException("Customer Already Registered with Email...!");

		Set<Address> a = cust.getAddresses();
		for(Address add : a) {
			add.setCustomer(cust);
		}
		Customer savedCustomer = custRepo.save(cust);

		return savedCustomer;

	}

	@Override
	public Customer removeCustomer(Integer id,String uuid) throws CustomerException, UserException {
		
		CurrentUserSession csession =  currentUserSessionRepo.findByUuid(uuid);
		
		
		Optional<Customer> cus = custRepo.findById(csession.getUserId());
		if (!cus.isPresent())
			throw new CustomerException("Customer doesn't exist!");
		if (!id.equals(csession.getUserId())) {
			throw new CustomerException("This is not your customer id Please insert your customer id");
		}
		Customer c= cus.get();
		custRepo.delete(c);
		logService.signOutUser(uuid);
		return cus.get();
	}

	@Override
	public Customer updateCustomer(Customer cust) throws CustomerException {
		Optional<Customer> optional = custRepo.findById(cust.getCustomerId());
		if (!optional.isPresent())
			throw new CustomerException("No customer exists with this information");
		Customer customer = custRepo.save(cust);
		if (customer == null)
			throw new CustomerException("customer not updated");
		return customer;
	}

	@Override
	public List<Customer> ViewAllCustomers(String location) throws CustomerException {

		List<Customer> viewAllCust = custRepo.findAll();
		if (viewAllCust.size() == 0) {
			throw new CustomerException("No Customer are there");
		} else {
			return viewAllCust;
		}

	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		Optional<Customer> optional = custRepo.findById(customerId);
		if (!optional.isPresent())
			throw new CustomerException("Customer not found");
		return optional.get();
	}

}
