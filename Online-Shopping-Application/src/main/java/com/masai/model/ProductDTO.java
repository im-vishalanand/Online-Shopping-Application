package com.masai.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProductDTO {

	private Integer productId;

	private String productName;

	private Double price;

	private String colour;

	private String dimension;

	private String manufacturer;

	private Integer quantity;
	
}
