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

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProductHandler(@Valid @RequestBody Product product) throws ProductException{
		
		Product addProd = productService.addProduct(product);
		
		return new ResponseEntity<Product>(addProd, HttpStatus.CREATED);	
		
	}
	
	
	@GetMapping("/viewAllProducts")
	public ResponseEntity<List<Product>> viewAllProductsHandler()  throws ProductException {

		List<Product> products = productService.viewAllProduct();

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProductHandler(@Valid @RequestBody Product product)  throws ProductException {
		
		Product prod = productService.updateProduct(product);
	
		return new ResponseEntity<Product>(prod, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/viewProduct")
	public ResponseEntity<Product> viewProductHandler(@Valid @RequestParam("prodId") Integer prodId) throws ProductException {

		Product product = productService.viewProduct(prodId);
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	
	@GetMapping("/viewProductByCategory")
	public ResponseEntity<List<Product>> viewProductByCategoryHandler(@Valid @RequestParam("categoryName") String categoryName) {

		List<Product> prodCateg = productService.viewProductByCategory(categoryName);

		return new ResponseEntity<List<Product>>(prodCateg, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<Product> deleteProductHandler(@Valid @RequestParam("productId") Integer productId) {
		
		Product product = productService.removeProduct(productId);
	
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
	