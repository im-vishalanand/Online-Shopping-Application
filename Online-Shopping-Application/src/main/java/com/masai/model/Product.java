package com.masai.model;

import jakarta.persistence.Embedded;
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
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String productName;
	
	private Double price;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String colour;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String dimension;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String specification;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String manufacturer;
	
	@NotNull
	private Integer quantity;
	
	@Embedded
	private Category category;
	
}
