package com.masai.service;

import java.util.List;

import com.masai.exception.ProductException;
import com.masai.model.Product;

public interface ProductService {
	public Product addProduct(Product product) throws ProductException;
	
	public List<Product> viewAllProduct() throws ProductException;
	
	public Product updateProduct(Product product) throws ProductException;
	
	public Product viewProduct(Integer id) throws ProductException;
	
	public List<Product> viewProductByCategory(String cName) throws ProductException;
	
	public Product removeProduct(Integer pId) throws ProductException;
}
