package com.masai.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AddressException;
import com.masai.exception.CustomerException;
import com.masai.model.Address;
import com.masai.model.Customer;
import com.masai.repository.AddressDao;
import com.masai.repository.CustomerRepo;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private CustomerRepo customerDao;

	@Override
	public Address createAddress(Address a, Integer id) throws AddressException, CustomerException {
		Optional<Customer> customer = customerDao.findById(id);
		if (customer == null)
			throw new CustomerException("Please provide the currect customer Id...!");

		Set<Address> addresses = customer.get().getAddresses();
		if (addresses.contains(a))
			throw new AddressException("Address is already mentioned");
		addresses.add(a);
		a.setCustomer(customer.get());

		Address address = addressDao.save(a);
		if (address == null)
			throw new AddressException("Address Not saved yet...!");

		return address;
	}

	@Override
	public Address removeAddress(Integer addressId) throws AddressException {
		Address add = addressDao.findById(addressId)
				.orElseThrow(() -> new AddressException("Address Not found for deleting"));

		if (add == null)
			throw new AddressException("Address Not found for deleting");

		addressDao.delete(add);

		return add;

	}

	@Override
	public Address updateAddress(Address a) throws AddressException {
		Optional<Address> optional = addressDao.findById(a.getAddressId());

		if (!optional.isPresent())
			throw new AddressException("This address does't exists");

		Customer customer = optional.get().getCustomer();
		a.setCustomer(customer);
		Address address = addressDao.save(a);

		return address;
	}

	@Override
	public Address viewAddress(Integer a) throws AddressException {
		Optional<Address> add = addressDao.findById(a);
		if (!add.isPresent())
			throw new AddressException("No address exits for the same");

		Address address = add.get();
		System.out.println(address);

		return address;
	}

	@Override
	public Set<Address> viewAllAddress(Integer id) throws CustomerException, AddressException {
		Optional<Customer> optional = customerDao.findById(id);
		if (!optional.isPresent())
			throw new CustomerException("No user exist with this id");

		Set<Address> addresses = optional.get().getAddresses();
		if (addresses.isEmpty())
			throw new AddressException("No address found for this customer");
		return addresses;
	}

}
