package com.masai.service;

import java.util.Set;

import com.masai.exception.AddressException;
import com.masai.exception.CustomerException;
import com.masai.model.Address;

public interface AddressService {
	public Address createAddress(Address a, Integer customerId) throws AddressException, CustomerException;

	public Address removeAddress(Integer addressId) throws AddressException;

	public Address updateAddress(Address a) throws AddressException;

	public Address viewAddress(Integer a) throws AddressException;

	public Set<Address> viewAllAddress(Integer id) throws CustomerException, AddressException;

}
