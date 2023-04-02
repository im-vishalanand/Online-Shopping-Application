package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.OrderException;
import com.masai.model.Orders;
import com.masai.repository.OrderDao;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
    private OrderDao orderDao;

    @Override
    public Orders addOrder(Orders order) {
    	
    	order.getCustomer().getListOfOrders().add(order);
    	
    	
        Orders save = orderDao.save(order);
        
        return save;
    }

    @Override
    public Orders updateOrder(Orders order)throws OrderException {
    	
        Optional<Orders> byId = orderDao.findById(order.getOrderId());

        
        if (byId.isPresent()) return orderDao.save(order);
        
        else throw new OrderException("No Order Found with this Id"+order.getOrderId());
    }

    @Override
    public Orders removeOrder(Integer orderId)throws OrderException {
    	
        Optional<Orders> byId = orderDao.findById(orderId);

        if (byId.isPresent()) {

            Orders order1 = byId.get();
            orderDao.delete(order1);
            return order1;

        }
        else throw new OrderException("No Order Found with this Id: "+orderId);
    }

    @Override
    public List<Orders> viewAllOrder()throws OrderException {
    	
        List<Orders> orderList = orderDao.findAll();

        if (!orderList.isEmpty()) {
        	
        	return orderList;
        }
        else throw new OrderException("No Order Found");
    }

    @Override
    public List<Orders> viewAllOrdersByLocation(String loc) {

        List<Orders> list= orderDao.getOrderByCity(loc);

        if( list.size() < 1) {
        	
            throw new OrderException("No order found with this userId.");
        }
        
        return list;

    }

    @Override
    public List<Orders> viewAllOrdersByUserId(int userid) {

        List<Orders> list = orderDao.getOrdersByUserId(userid);

        if( list.size() < 1) {
        	
            throw new OrderException("No order found with this userId.");
        
        }

        return list;

    }
}
