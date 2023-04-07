package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Validated
@Getter
@Setter
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	@NotNull(message = "orderDate should not be null")
	private LocalDate orderDate=LocalDate.now();

	@NotEmpty(message = "orderStatus cannot be empty")
	@NotNull(message = "orderStatus cannot be null")
	@NotBlank(message = "orderStatus cannot be blank")
	private String orderStatus;

	@NotNull(message = "addressId cannot be null")
	private Integer addressId;

	@NotEmpty(message = "location cannot be empty")
	@NotNull(message = "location cannot be null")
	@NotBlank(message = "location cannot be blank")
	private String location;

//	@JsonIgnore
	@ElementCollection
	@CollectionTable(name = "ordered_product", joinColumns = @JoinColumn(name = "order_id"))
	@Column(name = "product_id")
	private Map<Product, Integer> orderedProducts = new HashMap<>();

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.DETACH)
	private Customer customer;


}
