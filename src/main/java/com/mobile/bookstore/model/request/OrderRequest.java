package com.mobile.bookstore.model.request;

import java.sql.Date;
import java.sql.Time;

import org.springframework.lang.Nullable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class OrderRequest {
    @Nullable
	private int id = -1;
	@NonNull
	private int orderId;
	@NonNull
	private Date starDate;
	@NonNull
	private Date requireDate;
	@NonNull
	private boolean status;
	@NonNull
	private double totalPrice;
    @NonNull
    private int totalAmount;
	@NonNull
	private int accountId;
}
