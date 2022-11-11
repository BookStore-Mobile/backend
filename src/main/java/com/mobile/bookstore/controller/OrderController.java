package com.mobile.bookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobile.bookstore.model.request.BookRequest;
import com.mobile.bookstore.model.request.OrderRequest;
import com.mobile.bookstore.model.response.BookResponse;
import com.mobile.bookstore.model.response.OrderResponse;
import com.mobile.bookstore.service.OrderService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/Order")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
	@PostMapping(value = "/add")
	public ResponseEntity<OrderResponse> addBook(@RequestBody OrderRequest orderRequest) throws Exception {
		OrderResponse result = orderService.addOrder(orderRequest);
		if(result != null) {
			 return new ResponseEntity<OrderResponse>(result, HttpStatus.OK);
		}
		return new ResponseEntity<OrderResponse>(result, HttpStatus.CONFLICT);
	}
	@PostMapping(value = "/update")
	public ResponseEntity<OrderResponse> signUp(@RequestBody OrderRequest orderReq) throws Exception {
		OrderResponse result = orderService.updateOrders(orderReq);
		if(result != null) {
			 return new ResponseEntity<OrderResponse>(result, HttpStatus.OK);
		}
		return new ResponseEntity<OrderResponse>(result, HttpStatus.CONFLICT);
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<OrderResponse>> signUp(@RequestParam(name = "accountId") int accountId) throws Exception {
		List<OrderResponse> result = orderService.getAllOrder();
		if(result != null) {
			 return new ResponseEntity<List<OrderResponse>>(result, HttpStatus.OK);
		}
		return new ResponseEntity<List<OrderResponse>>(result, HttpStatus.CONFLICT);
	}
}
