package com.mobile.bookstore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "OrderDetail")
public class OrderDetail implements Serializable{
	@Id
	@Column(name = "order_id", nullable = false)
    private int orderId;
	@Id
	@Column(name = "book_id", nullable = false)
	private int bookId;
    @Column(name = "discount", length = 10)
    private float discount;
    @Column(name = "price_discount", length = 10)
    private double priceDiscount;
    @Column(name = "amount", length = 10, nullable = false)
    private int amount;
    @ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;
    @ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
    
}
