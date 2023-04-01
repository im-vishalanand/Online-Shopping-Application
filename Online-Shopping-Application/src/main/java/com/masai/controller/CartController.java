package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    
    @PostMapping("/addProductToCart")
    public ResponseEntity<Cart> addProductToCartHandler(@RequestBody Cart cart,@RequestBody Product product,@RequestParam("quantity") int quantity){
        Cart addProduct = cartService.addProductToCart(cart, product, quantity);
        return new ResponseEntity<>(addProduct,HttpStatus.CREATED);
    }

    @DeleteMapping("/removeProduct")
    public ResponseEntity<Cart> removeProductFromCartHandler(@RequestBody Cart cart,@RequestBody Product product){
        Cart removeProduct = cartService.removeProductFromCart(cart, product);
        return new ResponseEntity<>(removeProduct,HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateProductQuantity")
    public ResponseEntity<Cart> updateProductQuantityHandler(@RequestBody Cart cart,@RequestBody Product product,@RequestParam("quantity") int quantity){
        Cart updateProduct = cartService.updateProductQuantity(cart, product, quantity);
        return new ResponseEntity<>(updateProduct,HttpStatus.ACCEPTED);
    }
    
    

    @DeleteMapping("/removeAllProduct")
    public ResponseEntity<Cart> removeAllProductsHandler(@RequestBody Cart cart){
        Cart removeAllProduct = cartService.removeAllProducts(cart);
        return new ResponseEntity<>(removeAllProduct,HttpStatus.ACCEPTED);
    }


    @GetMapping("/viewAllProducts")
    public ResponseEntity<Cart> viewAllProductsHandler(@RequestBody Cart cart){
        Cart viewAllProducts = cartService.viewAllProducts(cart);
        return new ResponseEntity<>(viewAllProducts,HttpStatus.OK);
    }


}
