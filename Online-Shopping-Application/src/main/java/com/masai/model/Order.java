package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@ToString
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	@NotNull
	private LocalDate orderDate;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String orderStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@ElementCollection
	private List<ProductDTO> productDtoList= new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	

	
	
}
