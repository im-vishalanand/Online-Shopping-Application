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

	@NotNull
	@Size(min = 2, max = 20, message = "lastname should be greater then 2 and less the 20")
	private String lastName;

	@NotNull(message = "please provide the mobile number")
	@Size(min = 10, max = 10, message = "your mobile number length not appropreate")
	@Column(unique = true)
	private String mobileNumber;

	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 6, max = 15, message = "the password length is not apropriate")
	private String password;

	@NotNull
	@Size(min = 5, max = 8, message = "please privide role (admin or customer)")
	private String role;

	

}