package com.masai.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String firstName;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String lastName;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min = 10, max = 12)
	private String mobileNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Email
	private String email;
	
	
}
