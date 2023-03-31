package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
//@RequestMapping("/addresses")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/addresses")
	public ResponseEntity<Address> addAddressHandler(@Valid @RequestBody Address add) {
		Address ad = addressService.addAddress(add);
		return new ResponseEntity<Address>(ad, HttpStatus.OK);
	}

	@PutMapping("/addresses")
	public ResponseEntity<Address> updateAddressHandler(@RequestBody Address add) {
		Address ad = addressService.updateAddress(add);
		return new ResponseEntity<Address>(ad, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/addresses/{addressId}")
    public ResponseEntity<Address> deleteAddressHandler(@PathVariable("addressId") Integer addId) {
        Address ad = addressService.removeAddress(addId);
        return new ResponseEntity<Address>(ad, HttpStatus.OK);
    }
    
	@GetMapping("/addresses")
    public ResponseEntity<List<Address>> getAllAddressHandler() {
        List<Address> allAddress = addressService.viewAllAddress();
        return new ResponseEntity<List<Address>>(allAddress, HttpStatus.OK);
    }

    @GetMapping("/addresses/{addressId}")
    public ResponseEntity<Address> getAddressHandler(@PathVariable("addressId") Integer addressId) {

        Address existingAddress = addressService.viewAddress(addressId);

        return new ResponseEntity<Address>(existingAddress, HttpStatus.OK);

    }
}
