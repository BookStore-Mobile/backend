package com.mobile.bookstore.model;

import java.util.ArrayList;
import java.util.List;

import com.mobile.bookstore.entity.Account;
import com.mobile.bookstore.entity.Book;
import com.mobile.bookstore.entity.Category;
import com.mobile.bookstore.entity.Order;
import com.mobile.bookstore.model.request.BookRequest;
import com.mobile.bookstore.model.request.OrderRequest;
import com.mobile.bookstore.model.request.SignupRequest;
import com.mobile.bookstore.model.response.AccountResponse;
import com.mobile.bookstore.model.response.BookResponse;
import com.mobile.bookstore.model.response.LoginResponse;
import com.mobile.bookstore.model.response.OrderResponse;

public class ObjectMapper {
	public static BookResponse bookToBookResponse(Book book) {
		return BookResponse.builder().id(book.getId())
									 .author(book.getAuthor())
									 .categoryId(book.getCategory().getId())
									 .imageUrl(book.getImageUrl())
									 .price(book.getPrice())
									 .status(book.isStatus())
									 .build();
	}
	
	public static Book bookRequestToBook(BookRequest bookReq, Category bookCategory) {
		return Book.builder().id(bookReq.getId())
									 .author(bookReq.getAuthor())
									 .category(bookCategory)
									 .imageUrl(bookReq.getImageUrl())
									 .price(bookReq.getPrice())
									 .status(bookReq.isStatus())
									 .build();
	}
	public static List<BookResponse> booksToBookResponses(List<Book> books) {
		if(books != null && books.size() > 0) {
			List<BookResponse> bookResponses = new ArrayList<>();
			for(Book book : books) {
				bookResponses.add(bookToBookResponse(book));
			}
			return bookResponses;
		}
		return null;
	}

	public static OrderResponse orderToOrderResponse(Order order){
		return OrderResponse.builder().id(order.getId())
										.starDate(order.getStarDate())
										.requireDate(order.getRequireDate())
										.totalPrice(order.getTotalPrice())
										.totalAmount(order.getTotalAmount())
										.status(order.isStatus())
										.build();
	}

	public static List<OrderResponse> orderToOrderResponses(List<Order> orders){
		if(orders != null && orders.size() > 0) {
			List<OrderResponse> orderResponses = new ArrayList<>();
			for(Order order : orders) {
				orderResponses.add(orderToOrderResponse(order));
			}
			return orderResponses;
		}
		return null;
	}

	public static Order orderRequestToOrder(OrderRequest orderRequest){
		return Order.builder().id(orderRequest.getId())
										.starDate(orderRequest.getStarDate())
										.requireDate(orderRequest.getRequireDate())
										.totalPrice(orderRequest.getTotalPrice())
										.totalAmount(orderRequest.getTotalAmount())
										.status(orderRequest.isStatus())
										.build();
	}
	
    public static AccountResponse accountToAccountResponse(Account account) {
		AccountResponse accountResponse = AccountResponse.builder().id(account.getId()).username(account.getUsername())
				.status(account.isStatus()).password(account.getPassword()).fullname(account.getFullname()).
                qrCode(account.getQrcode()).build();
		return accountResponse;

	}
    
    public static LoginResponse accountToLoginResponse(Account account) {
		LoginResponse loginResponse = LoginResponse.builder().id(account.getId())
				.username(account.getUsername())
				.fullName(account.getFullname())
				.urlImg(account.getImageUrl())
				.qrCode(account.getQrcode())
				.role(account.getRole())
				.status(account.isStatus())
				.build();
		return loginResponse;

	}
    
}
