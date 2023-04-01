package com.masai.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Embeddable
@Entity
public class Category {

	@Id
	@NotNull(message="{Category.id.invalid}")
	@NotEmpty(message="{Category.id.invalid}")
	@NotBlank(message="{Category.id.invalid}")
//	@Size(min = 4, max = 6, message = "{Category.id.invalid}")
	private Integer categoryId;
	
	@NotNull(message = "{Category.name.invalid}")
	@NotEmpty(message = "{Category.name.invalid}")
	@NotBlank(message = "{Category.name.invalid}")
	private String categoryName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Product> productList;
}
