package com.masai.service;

import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.model.Product;

public interface AdminService {

	public Product addProduct(Product p) throws ProductException;

	public Product removeProduct(Integer pid, Integer sellerId) throws ProductException, UserException;

	public Product updateProduct(Product p) throws ProductException;

}
