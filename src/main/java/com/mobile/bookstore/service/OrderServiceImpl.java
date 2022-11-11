package com.mobile.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mobile.bookstore.entity.Order;
import com.mobile.bookstore.exception.CustomError;
import com.mobile.bookstore.exception.custom.BaseCustomException;
import com.mobile.bookstore.exception.custom.CustomNotFoundException;
import com.mobile.bookstore.exception.custom.CustomUnauthorizedException;
import com.mobile.bookstore.model.ObjectMapper;
import com.mobile.bookstore.model.request.OrderRequest;
import com.mobile.bookstore.model.response.OrderResponse;
import com.mobile.bookstore.repository.OrderRepo;
import com.mobile.bookstore.utils.AccountRole;
import com.mobile.bookstore.utils.BookUtil;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final BookUtil bookUtil;

    @Override
    public OrderResponse addOrder(OrderRequest orderRequest) throws BaseCustomException {
        if(orderRequest == null) throw new CustomNotFoundException(CustomError.builder().code("400").message("Bad Request").build());
		if(!bookUtil.checkRoleAccount(AccountRole.Admin, orderRequest.getAccountId())) throw new CustomUnauthorizedException(CustomError.builder().code("401")
				.message("Access denied, you need to be Admin to do this!").build());
                Order order = orderRepo.save(ObjectMapper.orderRequestToOrder(orderRequest));
                if(order != null) {
                    return ObjectMapper.orderToOrderResponse(order);
                } else throw new CustomNotFoundException(
                        CustomError.builder().code("404").message("DB Add Failed!").build());
        }

    @Override
    public List<OrderResponse> getAllOrder() {
        return ObjectMapper.orderToOrderResponses(orderRepo.findAll());
    }


    @Override
    public OrderResponse updateOrders(OrderRequest orderRequest) throws BaseCustomException {
        if(orderRequest == null) throw new CustomNotFoundException(CustomError.builder().code("400").message("Bad Request").build());
		if(!bookUtil.checkRoleAccount(AccountRole.Admin, orderRequest.getAccountId())) throw new CustomUnauthorizedException(CustomError.builder().code("401")
				.message("Access denied, you need to be Admin to do this!").build());
		if(orderRequest.getId() < 0) return null;
		Order orderInDB = orderRepo.findById(orderRequest.getId()).get();
		if(orderInDB == null) return null;
		
			Order order = orderRepo.save(ObjectMapper.orderRequestToOrder(orderRequest));
			if(order != null) {
				return ObjectMapper.orderToOrderResponse(order);
			} else throw new CustomNotFoundException(
					CustomError.builder().code("404").message("DB Add Failed!").build());
    }

    private Order updateOrder(Order order, OrderRequest orderRequest) {
		order.setStarDate(orderRequest.getStarDate());
        order.setRequireDate(orderRequest.getRequireDate());
        order.setTotalPrice(orderRequest.getTotalPrice());
        order.setTotalAmount(orderRequest.getTotalAmount());
		return order;
	}
}
