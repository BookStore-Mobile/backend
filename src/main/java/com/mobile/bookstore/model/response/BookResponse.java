package com.mobile.bookstore.model.response;

import org.springframework.lang.Nullable;

import com.mobile.bookstore.model.request.BookRequest;

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
@Builder
@Getter
@Setter
public class BookResponse {
	@Nullable
	private int id;
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
}
