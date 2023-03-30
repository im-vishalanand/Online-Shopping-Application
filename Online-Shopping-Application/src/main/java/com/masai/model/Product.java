package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@NotBlank(message = "{Product.name.invalid}")
	@NotEmpty(message = "{Product.name.invalid}")
	@NotNull(message = "{Product.name.invalid}")
	private String productName;

	@NotNull(message = "{Product.price.invalid}")
	private Double price;

	private String colour;

	private String dimension;

	@NotBlank(message = "{Product.specification.invalid}")
	@NotEmpty(message = "{Product.specification.invalid}")
	@NotNull(message = "{Product.specification.invalid}")
	private String specification;

	@NotBlank(message = "{Product.manufacturer.invalid}")
	@NotEmpty(message = "{Product.manufacturer.invalid}")
	@NotNull(message = "{Product.manufacturer.invalid}")
	private String manufacturer;
	
	@NotNull(message = "{Product.quantity.invalid}")
	private Integer quantity;
	
}
