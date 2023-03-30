package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AddressException;
import com.masai.model.Address;
import com.masai.repository.AddressDao;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressDao adao;

	@Override
	public Address addAddress(Address add) throws AddressException {
		Address addr = adao.save(add);
		return addr;
	}

	@Override
	public Address updateAddress(Address add) throws AddressException {
		Optional<Address> opt = adao.findById(add.getAddressId());
		if(opt.isPresent()) {
			return adao.save(add);
		}
		else {
			throw new AddressException("Address not avaible with id "+add.getAddressId());
		}
	}

	@Override
	public Address removeAddress(Integer addId) throws AddressException {
		Address addr = adao.findById(addId).orElseThrow(()-> new AddressException("Address not found with address id "+addId));
		return addr;
		
	}

	@Override
	public List<Address> viewAllAddress() throws AddressException {
		List<Address> opt = adao.findAll();
		if(opt.size() > 0) {
			return opt;
		}
		else {
			throw new AddressException("No address found");
		}
	}

	@Override
	public Address viewAddress(Integer addId) throws AddressException {
		Optional<Address> opt = adao.findById(addId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new AddressException("Address not available with id "+addId);
		}
	}


}
