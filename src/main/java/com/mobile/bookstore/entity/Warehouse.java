package com.mobile.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "Warehouse")
public class Warehouse {

    @Id
    @Column(name = "book_id", nullable = false)
    private int id;
    @Column(name = "unit_in_stock",length = 10, nullable = false)
    private int unitInStock;
    
    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    
}
