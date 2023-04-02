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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Address;
import com.masai.service.AddressService;

import jakarta.validation.Valid;
import lombok.val;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/addAddress")
	public ResponseEntity<Address> addAddressHandler(@Valid @RequestBody Address add) {
		Address ad = addressService.addAddress(add);
		return new ResponseEntity<Address>(ad, HttpStatus.OK);
	}

	@PutMapping("/updateAddress")
	public ResponseEntity<Address> updateAddressHandler(@Valid @RequestBody Address add) {
		Address ad = addressService.updateAddress(add);
		return new ResponseEntity<Address>(ad, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteAddress")
    public ResponseEntity<Address> deleteAddressHandler(@Valid @RequestParam("addressId") Integer addId) {
        Address ad = addressService.removeAddress(addId);
        return new ResponseEntity<Address>(ad, HttpStatus.OK);
    }
    
	@GetMapping("/getAllAddress")
    public ResponseEntity<List<Address>> getAllAddressHandler() {
        List<Address> allAddress = addressService.viewAllAddress();
        return new ResponseEntity<List<Address>>(allAddress, HttpStatus.OK);
    }

    @GetMapping("/getAddress")
    public ResponseEntity<Address> getAddressHandler(@Valid @RequestParam("addressId") Integer addressId) {

        Address existingAddress = addressService.viewAddress(addressId);

        return new ResponseEntity<Address>(existingAddress, HttpStatus.OK);

    }
}
