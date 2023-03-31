package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Cart;
import com.masai.model.Product;
import com.masai.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private CartService cartService;

    
    @PostMapping("/{quantity}")
    public ResponseEntity<Cart> addProductToCartHandler(@RequestBody Cart cart,@RequestBody Product product,@RequestParam("quantity") int quantity){
        Cart addProduct = cartService.addProductToCart(cart, product, quantity);
        return new ResponseEntity<>(addProduct,HttpStatus.CREATED);
    }



}
