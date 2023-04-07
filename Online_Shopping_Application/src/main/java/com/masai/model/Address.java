package com.masai.model;


import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Validated
@Data
@EqualsAndHashCode
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	@NotEmpty(message = "streetNo cannot be empty")
	@NotNull(message = "streetNo cannot be null")
	@NotBlank(message = "streetNo cannot be blank")
	private String streetNo;

	@NotEmpty(message = "buildingName cannot be empty")
	@NotNull(message = "buildingName cannot be null")
	@NotBlank(message = "buildingName cannot be blank")
	private String buildingName;

	@NotEmpty(message = "city cannot be empty")
	@NotNull(message = "city cannot be null")
	@NotBlank(message = "city cannot be blank")
	private String city;

	@NotEmpty(message = "state cannot be empty")
	@NotNull(message = "state cannot be null")
	@NotBlank(message = "state cannot be blank")
	private String state;

	@NotEmpty(message = "country cannot be empty")
	@NotNull(message = "country cannot be null")
	@NotBlank(message = "country cannot be blank")
	private String country;

	@NotEmpty(message = "pincode cannot be empty")
	@NotNull(message = "pincode cannot be null")
	@NotBlank(message = "pincode cannot be blank")
	@Size(min = 6, max = 6, message = "pincode should be of 6 digits")
	private String pincode;

	@JsonIgnore
	@JoinColumn(name = "customer_id")
	@ManyToOne(cascade = CascadeType.DETACH)
	private Customer customer;

	

}
