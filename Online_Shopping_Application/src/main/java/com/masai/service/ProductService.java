package com.masai.service;

import java.util.List;

import com.masai.exception.ProductException;
import com.masai.model.Product;

public interface ProductService {

	public List<Product> viewAllProducts() throws ProductException;

	public Product viewProduct(Integer id) throws ProductException;

	public List<Product> viewProductByCategory(String cname) throws ProductException;

	public List<Product> viewProductByProductName(String productName) throws ProductException;
}
