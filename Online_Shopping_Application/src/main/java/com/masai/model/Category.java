package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer catId;

	@NotEmpty(message = "category cannot be empty")
	@NotNull(message = "category cannot be null")
	@NotBlank(message = "category cannot be blank")
	@Column(unique = true)
	private String category;

	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "categorys")
	private List<Product> products = new ArrayList<>();

	

}
