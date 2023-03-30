package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.dto.ProductDTO;


public interface ProductDtoDao extends JpaRepository<ProductDTO, Integer> {

}
