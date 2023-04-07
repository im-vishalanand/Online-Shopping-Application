package com.masai.controller;

import java.util.Map;

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

import com.masai.exception.CartException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.model.CurrentUserSession;
import com.masai.model.Product;
import com.masai.service.CartService;
import com.masai.service.LogInService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {

	private CartService cSer;

	private LogInService logService;

	private CurrentUserSession cs;

	@PostMapping("/addProduct")
	public ResponseEntity<Cart> addNewProduct(@Valid @RequestBody Product p,
			@RequestParam Integer quantity, @RequestParam String uuid)
			throws LoginException, CartException, ProductException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		Integer cartId = cs.getCartId();

		Cart cart = cSer.getCartById(cartId);

		Cart cc = cSer.addProductToCart(cart, p, quantity);

		return new ResponseEntity<>(cc, HttpStatus.OK);
	}


	@DeleteMapping("/removeAllProducts")
	public ResponseEntity<Cart> removeAllProduct(@RequestParam String uuid) throws LoginException, CartException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		Integer cartId = cs.getCartId();

		Cart cc = cSer.removeAllProduct(cSer.getCartById(cartId));

		return new ResponseEntity<>(cc, HttpStatus.OK);
	}

	@DeleteMapping("/removeProduct")
	public ResponseEntity<Cart> removeProduct(@RequestBody Product p, @RequestParam String uuid)
			throws LoginException, CartException, ProductException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		Integer cartId = cs.getCartId();

		Cart cart = cSer.getCartById(cartId);

		Cart cc = cSer.removeProductFromCart(cart, p);

		return new ResponseEntity<>(cc, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateProductQuantity")
	public ResponseEntity<Cart> updateProductQuantity(@RequestParam("quantity") Integer quantity,
			@RequestBody Product p, @RequestParam String uuid) throws LoginException, CartException, ProductException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		Integer cartId = cs.getCartId();

		Cart cart = cSer.getCartById(cartId);

		Cart cc = cSer.updateProductQuantity(cart, p, quantity);
		return new ResponseEntity<>(cc, HttpStatus.OK);
	}

	@GetMapping("/viewAllProduct")
	public ResponseEntity<Map<Product, Integer>> viewAllProduct(@RequestParam String uuid)
			throws LoginException, CartException {

		this.setCs(logService.getSessionByUuid(uuid));

		if (cs == null)
			throw new LoginException("This user is not logged in");

		Integer cartId = cs.getCartId();

		Cart cart = cSer.getCartById(cartId);

		Map<Product, Integer> map = cSer.viewAllProduct(cart);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@Autowired
	public void setcSer(CartService cSer) {
		this.cSer = cSer;
	}

	@Autowired
	public void setLogService(LogInService logService) {
		this.logService = logService;
	}

	public void setCs(CurrentUserSession cs) {
		this.cs = cs;
	}

}
