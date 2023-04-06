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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	@NotNull
	private LocalDate orderDate=LocalDate.now();

	@NotBlank
	@NotNull
	@NotEmpty
	private String orderStatus;

	private Integer addressId;

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
