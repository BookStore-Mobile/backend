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
public class Warehouse {

    @Id
    @Column(name = "sach_id", nullable = false)
    private int sachId;
    @Column(name = "unit_in_stock",length = 10)
    private int unitInStock;
    
}
