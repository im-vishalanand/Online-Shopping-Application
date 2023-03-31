package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.exception.OrderException;
import com.masai.model.Orders;

public interface OrderDao extends JpaRepository<Orders, Integer> {

    @Query("select o from Orders o where o.address.city= ?1")
    public List<Orders> getOrderByCity(String city) throws OrderException;

    @Query("select o from Orders o where o.customer.mobileNumber=?1")
    public List<Orders> getOrdersByUserId(int userID);
}
