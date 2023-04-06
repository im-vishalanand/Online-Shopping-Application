package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.model.Category;
import com.masai.model.Product;
import com.masai.repository.CategoryRepo;
import com.masai.repository.ProductRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private ProductRepo prodRepo;

	@Autowired
	private CategoryRepo cRepo;

	@Override
	public Product addProduct(Product product) throws ProductException {
		Optional<Product> opt = null;
		if (product.getProductId() != null)
			opt = prodRepo.findById(product.getProductId());

		if (opt != null && opt.isPresent()) {
			throw new ProductException("Product Already Registered!.......");
		} else {
			String categoryName = product.getCategory();
			Category existingCategory = cRepo.findByCategory(categoryName);
			if (existingCategory == null) {
				Category category = new Category();
				category.setCategory(categoryName);
				category.getProducts().add(product);
				category = cRepo.save(category);
				product.setCategorys(category);
			} else {
				existingCategory.getProducts().add(product);
				product.setCategorys(existingCategory);
			}
			Product savedProduct = prodRepo.save(product);

			return savedProduct;
		}
	}

	@Override
	public Product removeProduct(Integer pid, Integer sellerId) throws ProductException, UserException {
		Optional<Product> opt = prodRepo.findById(pid);
		if (!opt.isPresent())
			throw new ProductException("This Product doesn't exist");
		if (!(opt.get().getSellerId().equals(sellerId)))
			throw new UserException("You are not elegible for removing this product...!");

		prodRepo.delete(opt.get());
		return opt.get();
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {

		Optional<Product> opt = prodRepo.findById(product.getProductId());

		if (!opt.isPresent())
			throw new ProductException("No Product exists with this information");

		Category cat = opt.get().getCategorys();
		product.setCategorys(cat);
		Integer sellerId = opt.get().getSellerId();
		product.setSellerId(sellerId);
		Product updatedProduct = prodRepo.save(product);
		if (updatedProduct == null)
			throw new ProductException("Product not updated");
		return updatedProduct;
	}

}
