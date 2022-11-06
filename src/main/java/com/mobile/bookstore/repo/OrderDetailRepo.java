package com.mobile.bookstore.repo;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mobile.bookstore.entity.OrderDetail;

@Repository
public interface OrderDetailRepo {
    List<OrderDetail> getOrderDetailsByMemberOrderId(@Param("order_id") int orderId);
}
