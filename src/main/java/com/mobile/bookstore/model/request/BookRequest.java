package com.mobile.bookstore.model.request;

import org.springframework.lang.Nullable;

import com.mobile.bookstore.model.response.BookResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class BookRequest {
	@Nullable
	private int id = -1;
	@NonNull
	private int categoryId;
	@NonNull
	private String author;
	@NonNull
	private String imageUrl;
	@NonNull
	private boolean status;
	@NonNull
	private double price;
	@NonNull
	private int accountId;
}
