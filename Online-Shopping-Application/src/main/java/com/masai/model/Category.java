package com.masai.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Category {

	@NotNull
	@NotBlank
	@NotEmpty
	private Integer categoryId;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String categoryName;
}
