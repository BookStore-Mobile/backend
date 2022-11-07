package com.mobile.bookstore.service;

import java.util.List;

import com.mobile.bookstore.entity.Order;
import com.mobile.bookstore.exception.custom.BaseCustomException;
import com.mobile.bookstore.model.request.OrderRequest;

public interface OrderService {
    
    public Order createNewOrder(OrderRequest orderRequest) throws BaseCustomException;
    
    public Order updateOrders(int id, OrderRequest orderRequest) throws BaseCustomException;
    public List<Order> getAllOrder();
    public Order getOrderByID(int id);
}
