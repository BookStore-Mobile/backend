package com.mobile.bookstore.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "[Order]")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private int id;
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
    
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<OrderDetail> orderDetails;
}
