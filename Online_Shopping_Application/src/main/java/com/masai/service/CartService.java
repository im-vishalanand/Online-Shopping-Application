package com.masai.service;

import java.util.Map;

import com.masai.exception.CartException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.model.Product;

public interface CartService {
	public Cart addProductToCart(Cart c, Product p, Integer quantity) throws CartException, ProductException;

	public Cart getCartById(Integer cartId) throws CartException;

	public Cart removeAllProduct(Cart c) throws CartException;

	public Cart removeProductFromCart(Cart c, Product p) throws CartException, ProductException;

	public Cart updateProductQuantity(Cart c, Product p, Integer quantity) throws CartException, ProductException;

	public Map<Product, Integer> viewAllProduct(Cart c) throws CartException;
}