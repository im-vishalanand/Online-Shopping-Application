package com.masai.service;

import com.masai.exception.CartException;
import com.masai.model.Cart;
import com.masai.model.Product;

public interface CartService {
	    public Cart addProductToCart(Cart cart, Product p,int quantity) throws CartException;

	    public Cart removeProductFromCart(Cart cart,Product p) throws CartException;

	    public Cart updateProductQuantity(Cart cart,Product p,int quantity) throws CartException;

	    public Cart removeAllProducts(Cart cart) throws CartException;

	    public Cart viewAllProducts(Cart cart) throws CartException;
}
