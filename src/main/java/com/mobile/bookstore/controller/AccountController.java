package com.mobile.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.bookstore.model.request.LoginRequest;
import com.mobile.bookstore.model.request.SignupRequest;
import com.mobile.bookstore.model.response.LoginResponse;
import com.mobile.bookstore.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountController {
	private final AccountService accService;
	@PostMapping(value = "/signUp")
	public ResponseEntity<Boolean> signUp(@RequestBody SignupRequest SignUpReq) throws Exception {
		boolean result = accService.signUp(SignUpReq);
		if(result) {
			 return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(result, HttpStatus.CONFLICT);
	}
	@PostMapping(value = "/signUpGoogle")
	public ResponseEntity<Boolean> signUp(@RequestBody LoginRequest loginRequest) throws Exception {
		boolean result = accService.signUpAccountByGoogle(loginRequest);
		if(result) {
			 return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(result, HttpStatus.CONFLICT);
	}
}
