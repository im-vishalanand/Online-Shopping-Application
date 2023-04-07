package com.masai.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class CurrentUserSession {

	@Id
	@Column(unique = true)
	private Integer userId;

	@NotEmpty(message = "uuid cannot be empty")
	@NotNull(message = "uuid cannot be null")
	@NotBlank(message = "uuid cannot be blank")
	@Size(max = 10)
	private String uuid;

	@NotNull(message = "cartId cannot be empty")
	private Integer cartId;

	@NotEmpty(message = "role cannot be empty")
	@NotNull(message = "role cannot be null")
	@NotBlank(message = "role cannot be blank")
	@Size(max = 20, message = "invalid role")
	private String role;

	

}
