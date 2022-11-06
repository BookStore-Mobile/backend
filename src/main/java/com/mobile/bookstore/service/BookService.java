package com.mobile.bookstore.service;

import java.util.List;

import com.mobile.bookstore.exception.custom.BaseCustomException;
import com.mobile.bookstore.model.request.BookRequest;
import com.mobile.bookstore.model.response.BookResponse;

public interface BookService {
	public BookResponse AddBook(BookRequest bookReq) throws BaseCustomException;
	
	public BookResponse UpdateBook(BookRequest bookReq) throws BaseCustomException;
	
	public List<BookResponse> viewAllBooks(int accountId) throws BaseCustomException;
	
}
