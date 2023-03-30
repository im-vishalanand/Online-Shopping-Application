package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.exception.OrderException;
import com.masai.model.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {

    @Query("select o from Orders o where o.orderAddress.city= ?1")
    public List<Order> getOrderByCity(String city) throws OrderException;

    @Query("select o from Orders o where o.customer.mobileNumber=?1")
    public List<Order> getOrdersByUserId(int userID);
}
