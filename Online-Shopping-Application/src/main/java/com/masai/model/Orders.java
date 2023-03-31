package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

//	@NotNull(message = "{Order.date.invalid}")
//	private LocalDate orderDate;
//
//	@NotNull(message = "{Order.status.invalid}")
//	@NotEmpty(message = "{Order.status.invalid}")
//	@NotBlank(message = "{Order.status.invalid}")
//	private String orderStatus;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> productList = new ArrayList<>();


	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	

	
	
}
