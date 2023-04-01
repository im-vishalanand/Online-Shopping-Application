package com.masai.service;

import java.util.List;

import com.masai.exception.OrderException;
import com.masai.model.Orders;

public interface OrderService {
	public Orders addOrder(Orders order);

    public Orders updateOrder(Orders order) throws OrderException;

    public Orders removeOrder(Integer orderId) throws OrderException;

    public List<Orders> viewAllOrder() throws OrderException;

    public List<Orders> viewAllOrdersByLocation(String loc);

    public List<Orders> viewAllOrdersByUserId(int userid);
}
