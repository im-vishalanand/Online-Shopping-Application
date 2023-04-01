package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@NotNull(message = "{User.id.invalid}")
	@NotBlank(message = "{User.id.invalid}")
	@NotEmpty(message = "{User.id.invalid}")
	@Size(min = 10, max = 12, message = "{User.id.invalid}")
	private String id;   // It is the mobile number

	@NotNull(message = "{User.password.invalid}")
	@NotBlank(message = "{User.password.invalid}")
	@NotEmpty(message = "{User.password.invalid}")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){6,12}$", message = "{Customer.password.invalid}")
	private String password;

	
	@NotNull(message = "{User.role.invalid}")
	@NotBlank(message = "{User.role.invalid}")
	@NotEmpty(message = "{User.role.invalid}")
	private String role;
}
