package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exception.AddressException;
import com.masai.exception.CustomerException;
import com.masai.exception.OrderException;
import com.masai.exception.ProductException;
import com.masai.model.Orders;

public interface OrderService {

	public Orders addOrders(Orders orders, Integer customerId, Integer addressId)
			throws OrderException, CustomerException, ProductException, AddressException;

	public Orders removeOrder(Orders orders) throws OrderException;

	public Orders updateOrders(Orders orders) throws OrderException;

	public List<Orders> viewAllOrders(LocalDate date) throws OrderException;

	public List<Orders> viewAllOrdersByLocation(String location) throws OrderException;

	public List<Orders> viewAllOrdersByUserId(Integer userId) throws OrderException, CustomerException;

	public Orders viewOrder(Integer ordersId) throws OrderException;

}
