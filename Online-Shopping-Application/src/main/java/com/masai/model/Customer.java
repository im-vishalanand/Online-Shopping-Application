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
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> listOfOrders = new ArrayList<>();

	@JsonIgnore
	public List<Order> getListOfOrders() {
		return listOfOrders;
	}

	@JsonIgnore
	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}
	
	
	@Column(unique = true)
	@NotBlank(message = "User name status can't blank")
	@Size(min = 3,max = 8, message = "User name length should be 3 and 8 characters!")
	private String userName;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{5,15}$",message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit " )
	private String password;

	
}
