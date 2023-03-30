package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Customer;

public interface CustomerInterface extends JpaRepository<Customer, Integer>{

}
