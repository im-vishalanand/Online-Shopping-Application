package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.OrderException;
import com.masai.model.Order;
import com.masai.repository.OrderDao;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
    private OrderDao orderDao;

    @Override
    public Order addOrder(Order order) {
        Order save = orderDao.save(order);
        return save;
    }

    @Override
    public Order updateOrder(Order order)throws OrderException {
        Optional<Order> byId = orderDao.findById(order.getOrderId());

        if (byId.isPresent()) return orderDao.save(order);
        else throw new OrderException("No Order Found with this Id"+order.getOrderId());
    }

    @Override
    public Order removeOrder(Order order)throws OrderException {
        Optional<Order> byId = orderDao.findById(order.getOrderId());

        if (byId.isPresent()) {

            Order order1 = byId.get();
            orderDao.delete(order1);
            return order1;

        }
        else throw new OrderException("No Order Found with this Id"+order.getOrderId());
    }

    @Override
    public Order viewOrder(Order order)throws OrderException {
        Optional<Order> byId = orderDao.findById(order.getOrderId());

        if (byId.isPresent()) return orderDao.save(order);
        else throw new OrderException("No Order Found with this Id"+order.getOrderId());
    }

    @Override
    public List<Order> viewAllOrdersByLocation(String loc) {

        List<Order> list= orderDao.getOrderByCity(loc);

        if( list.size() < 1) {
            throw new OrderException("No order found with this userId.");
        }
        return list;

    }

    @Override
    public List<Order> viewAllOrdersByUserId(int userid) {

        List<Order> list = orderDao.getOrdersByUserId(userid);

        if( list.size() < 1) {
            throw new OrderException("No order found with this userId.");
        }

        return list;

    }
}
