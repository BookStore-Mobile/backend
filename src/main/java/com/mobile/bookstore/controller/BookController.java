package com.mobile.bookstore.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.sym.Name;
import com.mobile.bookstore.model.request.BookRequest;
import com.mobile.bookstore.model.request.SignupRequest;
import com.mobile.bookstore.model.response.BookResponse;
import com.mobile.bookstore.service.BookService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/book")
@RestController
@RequiredArgsConstructor
public class BookController {
	private final BookService bookService;
	@PostMapping(value = "/add")
	public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest bookReq) throws Exception {
		BookResponse result = bookService.AddBook(bookReq);
		if(result != null) {
			 return new ResponseEntity<BookResponse>(result, HttpStatus.OK);
		}
		return new ResponseEntity<BookResponse>(result, HttpStatus.CONFLICT);
	}
	@PostMapping(value = "/update")
	public ResponseEntity<BookResponse> signUp(@RequestBody BookRequest bookReq) throws Exception {
		BookResponse result = bookService.UpdateBook(bookReq);
		if(result != null) {
			 return new ResponseEntity<BookResponse>(result, HttpStatus.OK);
		}
		return new ResponseEntity<BookResponse>(result, HttpStatus.CONFLICT);
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<BookResponse>> signUp(@RequestParam(name = "accountId") int accountId) throws Exception {
		List<BookResponse> result = bookService.viewAllBooks(accountId);
		if(result != null) {
			 return new ResponseEntity<List<BookResponse>>(result, HttpStatus.OK);
		}
		return new ResponseEntity<List<BookResponse>>(result, HttpStatus.CONFLICT);
	}
}
