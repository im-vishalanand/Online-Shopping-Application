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
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Validated
@Data
@EqualsAndHashCode
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;

	private String streetNo;

	private String buildingName;

	@NotEmpty
	@NotNull
	@NotBlank
	private String city;

	@NotEmpty
	@NotNull
	@NotBlank
	private String state;

	@NotEmpty
	@NotNull
	@NotBlank
	private String country;

	private String pincode;

	@JsonIgnore
	@JoinColumn(name = "customer_id")
	@ManyToOne(cascade = CascadeType.DETACH)
	private Customer customer;

	

}
