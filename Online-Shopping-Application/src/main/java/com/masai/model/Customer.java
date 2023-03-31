package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

	@NotNull(message = "{Customer.name.invalid}")
	@NotEmpty(message = "{Customer.name.invalid}")
	@NotBlank(message = "{Customer.name.invalid}")
	private String firstName;

	@NotNull(message = "{Customer.name.invalid}")
	@NotEmpty(message = "{Customer.name.invalid}")
	@NotBlank(message = "{Customer.name.invalid}")
	private String lastName;

	@NotNull(message = "{Customer.contact.invalid}")
	@NotEmpty(message = "{Customer.contact.invalid}")
	@NotBlank(message = "{Customer.contact.invalid}")
	@Size(min = 10, max = 12, message = "{Customer.contact.invalid}")
	private String mobileNumber;

	@NotNull(message = "{Customer.password.invalid}")
	@NotEmpty(message = "{Customer.password.invalid}")
	@NotBlank(message = "{Customer.password.invalid}")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){6,12}$", message = "{Customer.password.invalid}")
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@NotNull(message = "{Customer.email.invalid}")
	@NotEmpty(message = "{Customer.email.invalid}")
	@NotBlank(message = "{Customer.email.invalid}")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "{Customer.email.invalid}")
	private String email;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Orders> listOfOrders = new ArrayList<>();
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;


	
}
