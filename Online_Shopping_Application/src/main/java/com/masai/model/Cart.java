package com.masai.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "cart_id")
	private Integer cartId;

	@ElementCollection
	private Map<Product, Integer> Products = new HashMap<>();

	public Integer getCartId() {
		return cartId;
	}

	public Map<Product, Integer> getProducts() {
		return Products;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	@Bean(value = "products")
	public void setProducts(Map<Product, Integer> products) {
		Products = products;
	}

}
