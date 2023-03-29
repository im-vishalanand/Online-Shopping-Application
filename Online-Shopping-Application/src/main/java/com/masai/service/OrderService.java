package com.masai.service;

import java.util.List;

import com.masai.exception.OrderException;
import com.masai.model.Order;

public interface OrderService {
	public Order addOrder(Order order);

    public Order updateOrder(Order order) throws OrderException;

    public Order removeOrder(Order order) throws OrderException;

    public Order viewOrder(Order order) throws OrderException;

    public List<Order> viewAllOrdersByLocation(String loc);

    public List<Order> viewAllOrdersByUserId(int userid);
}
