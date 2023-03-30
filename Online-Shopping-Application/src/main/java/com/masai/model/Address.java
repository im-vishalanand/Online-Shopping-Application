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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	@NotNull(message = "{Address.streetname.invalid}")
	@NotEmpty(message = "{Address.streetname.invalid}")
	@NotBlank(message = "{Address.streetname.invalid}")
	private String streetName;

	@NotNull(message = "{Address.buildingname.invalid}")
	@NotEmpty(message = "{Address.buildingname.invalid}")
	@NotBlank(message = "{Address.buildingname.invalid}")
	private String buildingName;

	@NotNull(message = "{Address.city.invalid}")
	@NotEmpty(message = "{Address.city.invalid}")
	@NotBlank(message = "{Address.city.invalid}")
	@Size(min = 2, message = "{Address.city.invalid}")
	private String city;

	@NotNull(message = "{Address.state.invalid}")
	@NotEmpty(message = "{Address.state.invalid}")
	@NotBlank(message = "{Address.state.invalid}")
	@Size(min = 2, message = "{Address.city.invalid}")
	private String state;

	@NotNull(message = "{Address.pincode.invalid}")
	@NotEmpty(message = "{Address.pincode.invalid}")
	@NotBlank(message = "{Address.pincode.invalid}")
	@Size(min = 6, max = 6, message = "{Address.city.invalid}")
	private String pincode;
	
	@NotNull(message = "{Address.country.invalid}")
	@NotEmpty(message = "{Address.country.invalid}")
	@NotBlank(message = "{Address.country.invalid}")
	@Size(min = 2, message = "{Address.city.invalid}")
	private String country;
}
