package com.mobile.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.bookstore.model.request.CustomLoginRequest;
import com.mobile.bookstore.model.request.LoginRequest;
import com.mobile.bookstore.model.response.LoginResponse;
import com.mobile.bookstore.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class AuthenController {
	private final AccountService accService;
	@PostMapping(value = "/loginGoogle")
	public ResponseEntity<LoginResponse> loginGoogle(@RequestBody LoginRequest loginRequest) throws Exception {
		LoginResponse loginResponse = accService.loginGoogle(loginRequest);
		if(loginResponse != null) {
			 return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
		}
		return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.CONFLICT);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<LoginResponse> login(@RequestBody CustomLoginRequest loginRequest) throws Exception {
		LoginResponse loginResponse = accService.login(loginRequest);
		if(loginResponse != null) {
			 return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
		}
		return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.CONFLICT);
	}
}
