package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 5)
	private String id;

	@NotNull
	@NotBlank
	@NotEmpty
	private String password;

	@NotNull
	@NotBlank
	@NotEmpty
	private String role;
}
