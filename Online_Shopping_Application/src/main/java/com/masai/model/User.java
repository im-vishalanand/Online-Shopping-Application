package com.masai.model;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Validated
@Getter
@Setter
public class User {

	private Integer userId;

	@Email(message = "please provide the correct email")
	@NotNull(message = "please provide the email...!")
	@Column(unique = true)
	private String email;

	@NotNull
	@Size(min = 3, max = 20, message = "firstname should be greater then 3 and less the 20")
	private String firstName;

	@NotEmpty(message = "lastName cannot be empty")
	@NotNull(message = "lastName cannot be null")
	@NotBlank(message = "lastName cannot be blank")
	@Size(min = 2, max = 20, message = "lastname should be greater then 2 and less the 20")
	private String lastName;

	@NotEmpty(message = "mobileNumber cannot be empty")
	@NotNull(message = "mobileNumber cannot be null")
	@NotBlank(message = "mobileNumber cannot be blank")
	@Size(min = 10, max = 10, message = "mobile number should be of 10 digits only")
	@Column(unique = true)
	private String mobileNumber;

	@NotEmpty(message = "password cannot be empty")
	@NotNull(message = "password cannot be null")
	@NotBlank(message = "password cannot be blank")
	@Size(min = 6, max = 15, message = "length of the password should be greater than 6 characters and smaller than 15 characters")
	private String password;

	@NotEmpty(message = "role cannot be empty")
	@NotNull(message = "role cannot be null")
	@NotBlank(message = "role cannot be blank")
	@Size(min = 5, max = 8, message = "please privide role (admin or customer)")
	private String role;

	

}