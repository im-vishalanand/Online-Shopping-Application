package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping
	public ResponseEntity<Product> addProductHandler(@Valid @RequestBody Product product) throws ProductException{
		
		Product addProd = productService.addProduct(product);
		
		return new ResponseEntity<Product>(addProd, HttpStatus.CREATED);	
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<Product>> viewAllProductsHandler() {

		List<Product> products = productService.viewAllProduct();

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) {
		
		Product prod = productService.updateProduct(product);
	
		return new ResponseEntity<Product>(prod, HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	