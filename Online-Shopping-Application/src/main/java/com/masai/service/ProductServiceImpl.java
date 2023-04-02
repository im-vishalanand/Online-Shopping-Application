package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.model.Category;
import com.masai.model.Product;
import com.masai.repository.ProductDao;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao pdao;
	
	@Override
	public List<Product> viewAllProduct() throws ProductException {
		List<Product> products = pdao.findAll();
		if(products.size() > 0) {
			return products;
		}
		else {
			throw new ProductException("Product not available");
		}
	}

	@Override
	public Product addProduct(Product product) throws ProductException {

		
		Category category= product.getCategory(); 
		
		category.getProductList().add(product);
		
		Product prod = pdao.save(product);
		
		return prod;
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		
		Optional<Product> opt = pdao.findById(product.getProductId());
		
		if(opt.isPresent()) {
			
			return pdao.save(product);
		}
		else {
			
			throw new ProductException("Invalid product details");
		}
	}

	@Override
	public Product viewProduct(Integer id) throws ProductException {
		
		Optional<Product> opt = pdao.findById(id);
		
		if(opt.isPresent()) {
			
			return opt.get();
			
		}
		
		else {
			
			throw new ProductException("Product is not available with id number "+id);
		
		}
	}

	@Override
	public List<Product> viewProductByCategory(String cName) throws ProductException {
		
		List<Product> products = pdao.viewByCategoryName(cName);
		
		if(products.size() > 0) {
		
			return products;
		
		}
		
		throw new ProductException("Product is not available with category name "+cName);
	}

	@Override
	public Product removeProduct(Integer pId) throws ProductException {
		
		Product prod = pdao.findById(pId).orElseThrow(()-> new ProductException("Product not availabe with product id "+pId));
		
		pdao.delete(prod);
		
		return prod;
	}
}
