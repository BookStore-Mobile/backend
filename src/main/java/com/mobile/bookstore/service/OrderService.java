package com.mobile.bookstore.service;

import java.util.List;

import com.mobile.bookstore.entity.Order;
import com.mobile.bookstore.exception.custom.BaseCustomException;
import com.mobile.bookstore.model.request.OrderRequest;
import com.mobile.bookstore.model.response.OrderResponse;

public interface OrderService {
    
    public OrderResponse addOrder(OrderRequest orderRequest) throws BaseCustomException;
    
    public OrderResponse updateOrders(OrderRequest orderRequest) throws BaseCustomException;
    public List<OrderResponse> getAllOrder();
}
