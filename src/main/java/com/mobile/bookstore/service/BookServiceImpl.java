package com.mobile.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mobile.bookstore.entity.Book;
import com.mobile.bookstore.entity.Category;
import com.mobile.bookstore.exception.CustomError;
import com.mobile.bookstore.exception.custom.BaseCustomException;
import com.mobile.bookstore.exception.custom.CustomNotFoundException;
import com.mobile.bookstore.exception.custom.CustomUnauthorizedException;
import com.mobile.bookstore.model.ObjectMapper;
import com.mobile.bookstore.model.request.BookRequest;
import com.mobile.bookstore.model.response.BookResponse;
import com.mobile.bookstore.repository.BookRepository;
import com.mobile.bookstore.repository.CategoryRepository;
import com.mobile.bookstore.utils.AccountRole;
import com.mobile.bookstore.utils.BookUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

	private final BookRepository bookRepo;
	private final CategoryRepository categoryRepo;
	private final BookUtil bookUtil;
	
	@Override
	public BookResponse AddBook(BookRequest bookReq) throws BaseCustomException{
		if(bookReq == null) throw new CustomNotFoundException(CustomError.builder().code("400").message("Bad Request").build());
		if(!bookUtil.checkRoleAccount(AccountRole.Admin, bookReq.getAccountId())) throw new CustomUnauthorizedException(CustomError.builder().code("401")
				.message("Access denied, you need to be Admin to do this!").build());
		Category categoryBook = categoryRepo.findById(bookReq.getCategoryId()).get();
		if(categoryBook != null) {
			Book book = bookRepo.save(ObjectMapper.bookRequestToBook(bookReq, categoryBook));
			if(book != null) {
				return ObjectMapper.bookToBookResponse(book);
			} else throw new CustomNotFoundException(
					CustomError.builder().code("404").message("DB Add Failed!").build());
		} else throw new CustomNotFoundException(
				CustomError.builder().code("404").message("Not Found Category Book!").build());
	}

	@Override
	public BookResponse UpdateBook(BookRequest bookReq) throws BaseCustomException{
		if(bookReq == null) throw new CustomNotFoundException(CustomError.builder().code("400").message("Bad Request").build());
		if(!bookUtil.checkRoleAccount(AccountRole.Admin, bookReq.getAccountId())) throw new CustomUnauthorizedException(CustomError.builder().code("401")
				.message("Access denied, you need to be Admin to do this!").build());
		if(bookReq.getId() < 0) return null;
		Book bookInDB = bookRepo.findById(bookReq.getId()).get();
		if(bookInDB == null) return null;
		Category categoryBook = categoryRepo.findById(bookReq.getCategoryId()).get();
		if(categoryBook != null) {
			Book book = bookRepo.save(ObjectMapper.bookRequestToBook(bookReq, categoryBook));
			if(book != null) {
				return ObjectMapper.bookToBookResponse(book);
			} else throw new CustomNotFoundException(
					CustomError.builder().code("404").message("DB Add Failed!").build());
		} else throw new CustomNotFoundException(
				CustomError.builder().code("404").message("Not Found Category Book!").build());
	}

	@Override
	public List<BookResponse> viewAllBooks(int accountId) throws BaseCustomException{
		if(!bookUtil.checkRoleAccount(AccountRole.Admin, accountId)) throw new CustomUnauthorizedException(CustomError.builder().code("401")
				.message("Access denied, you need to be Admin to do this!").build());
		return ObjectMapper.booksToBookResponses(bookRepo.findAll());
	}

}
