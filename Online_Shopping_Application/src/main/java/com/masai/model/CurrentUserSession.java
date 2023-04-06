package com.masai.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class CurrentUserSession {

	@Id
	@Column(unique = true)
	private Integer userId;

	@Size(max = 10)
	private String uuid;

	@NotNull
	private Integer cartId;

	@Size(max = 20, message = "invalid role")
	private String role;

	

}
