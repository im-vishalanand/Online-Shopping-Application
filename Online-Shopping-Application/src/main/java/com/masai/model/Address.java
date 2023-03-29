package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String streetNo;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String buildingName;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String city;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String state;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String country;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 6, max = 6)
	private String pincode;
}
