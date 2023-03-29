package com.masai.service;

import java.util.List;

import com.masai.exception.AddressException;
import com.masai.model.Address;

public interface AddressService {
	public Address addAddress(Address add) throws AddressException;
	
	public Address updateAddress(Address add) throws AddressException;
	
	public Address removeAddress(Integer addId) throws AddressException;
	
	public List<Address> viewAllAddress() throws AddressException;
	
	public Address viewAddress(Integer addId) throws AddressException;
}
