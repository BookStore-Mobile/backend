package com.mobile.bookstore.response;
import java.sql.Date;

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
public class OrderResponse {

    private int id;
    
    private Date starDate;
    
    private Date requireDate;
   
    private double totalPrice;
    
    private int totalAmount;
   
    private boolean status;
}