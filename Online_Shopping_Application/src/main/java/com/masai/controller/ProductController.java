package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Product;
import com.masai.service.LogInService;
import com.masai.service.ProductService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	private LogInService logService;

	private CurrentUserSession cs;

	@GetMapping("/viewAllProducts")
	public ResponseEntity<List<Product>> viewAllProductsHandler(@RequestParam String uuid)
			throws ProductException, LoginException {

		List<Product> products = productService.viewAllProducts();

		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/viewProductByCategory")
	public ResponseEntity<List<Product>> viewProductByCategoryHandler(@PathParam(value = "category") String category,
			@RequestParam String uuid) throws LoginException, ProductException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		List<Product> products = productService.viewProductByCategory(category);

		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("viewProductByName")
	public ResponseEntity<List<Product>> viewProductByNameHandler(@RequestParam(value = "productName") String productName,
			@RequestParam String uuid) throws LoginException, ProductException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		List<Product> products = productService.viewProductByProductName(productName);

		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/viewProductById")
	public ResponseEntity<Product> viewProductHandler(@PathParam(value = "productId") Integer productId,
			@RequestParam String uuid) throws LoginException, ProductException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		Product p = productService.viewProduct(productId);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	public void setLogService(LogInService logService) {
		this.logService = logService;
	}

	public void setCs(CurrentUserSession cs) {
		this.cs = cs;
	}

}
