package com.mobile.bookstore.model.response;
import java.sql.Date;

import org.springframework.lang.Nullable;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    @Nullable
    private int id;
    @NonNull
    private Date starDate;
    @NonNull
    private Date requireDate;
   @NonNull
    private double totalPrice;
    @NonNull
    private int totalAmount;
   @NonNull
    private boolean status;
}