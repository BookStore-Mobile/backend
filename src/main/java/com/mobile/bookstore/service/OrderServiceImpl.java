package com.mobile.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.mobile.bookstore.entity.Order;
import com.mobile.bookstore.exception.custom.BaseCustomException;
import com.mobile.bookstore.exception.custom.CustomNotFoundException;
import com.mobile.bookstore.model.request.OrderRequest;
import com.mobile.bookstore.repository.OrderRepo;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Override
    public Order createNewOrder(OrderRequest orderRequest) throws BaseCustomException {
        Order order = new Order();
        order.setStarDate(orderRequest.getStarTime());
        order.setRequireDate(orderRequest.getRequireTime());
        order.setTotalPrice(orderRequest.getTotalPrice());
        order.setTotalAmount(orderRequest.getTotalAmount());
        return order;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrderByID(int id) {
        return orderRepo.findOrderById(id);
    }

    @Override
    public Order updateOrders(int id, OrderRequest orderRequest) throws BaseCustomException {
        if (!orderRepo.existsById(id)) {
			throw new CustomNotFoundException(null);
		}
		Order order = orderRepo.getById(id);
		return orderRepo.save(updateOrder(order, orderRequest));
    }

    private Order updateOrder(Order order, OrderRequest orderRequest) {
		order.setStarDate(orderRequest.getStarTime());
        order.setRequireDate(orderRequest.getRequireTime());
        order.setTotalPrice(orderRequest.getTotalPrice());
        order.setTotalAmount(orderRequest.getTotalAmount());
		return order;
	}
}
