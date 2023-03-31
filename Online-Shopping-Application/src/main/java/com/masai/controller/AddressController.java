package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Address;
import com.masai.service.AddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public ResponseEntity<Address> addAddressHandler(@Valid @RequestBody Address add) {
		Address ad = addressService.addAddress(add);
		return new ResponseEntity<Address>(ad, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Address> updateAddressHandler(@RequestBody Address add) {
		Address ad = addressService.updateAddress(add);
		return new ResponseEntity<Address>(ad, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{addressId}")
    public ResponseEntity<Address> deleteAddressHandler(@PathVariable("addressId") Integer addId) {
        Address ad = addressService.removeAddress(addId);
        return new ResponseEntity<Address>(ad, HttpStatus.OK);
    }
    
}
