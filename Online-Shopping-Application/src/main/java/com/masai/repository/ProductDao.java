package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	@Query("select p from Product p where p.category.categoryName = ?1")
	public List<Product> viewByCategoryName(String cName);
}
