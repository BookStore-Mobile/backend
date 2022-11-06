package com.mobile.bookstore.entity;

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
public class OrderDetail {
    @Id
    @Column(name = "order_detail_id", nullable = false)
    private int orderDetailId;
    @Column(name = "sach_id", nullable = false)
    private int sachId;
    @Column(name = "discount", length = 10)
    private float discount;
    @Column(name = "price_discount", length = 10)
    private double priceDiscount;
    @Column(name = "amount", length = 10)
    private int amount;
}
