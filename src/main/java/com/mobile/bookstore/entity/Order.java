package com.mobile.bookstore.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Column(name = "start_date", length = 10)
    private Date starDate;
    @Column(name = "require_date", length = 10)
    private Date requireDate;
    @Column(name = "total_price", length = 20)
    private double totalPrice;
    @Column(name = "total_amount", length = 10)
    private int totalAmount;
    @Column(name = "status", nullable = false)
    private boolean status;
}
