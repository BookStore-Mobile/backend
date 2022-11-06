package com.mobile.bookstore.service;
import java.util.List;

import com.mobile.bookstore.entity.Account;
import com.mobile.bookstore.exception.custom.BaseCustomException;
import com.mobile.bookstore.exception.custom.CustomDuplicateFieldException;
import com.mobile.bookstore.exception.custom.CustomUnauthorizedException;
import com.mobile.bookstore.model.request.CustomLoginRequest;
import com.mobile.bookstore.model.request.LoginRequest;
import com.mobile.bookstore.model.request.SignupRequest;
import com.mobile.bookstore.model.response.AccountResponse;
import com.mobile.bookstore.model.response.LoginResponse;

public interface AccountService {
    public Account findAccountByUsername(String username);

    public List<Account> getListAccount();

    public AccountResponse getAccountByID(int id);

    public AccountResponse createNewAccount(SignupRequest signupRequest) throws CustomDuplicateFieldException, CustomUnauthorizedException;

    public AccountResponse updateAccount(int id, SignupRequest signupRequest) throws BaseCustomException;
    
    public LoginResponse login(CustomLoginRequest customLoginReq) throws BaseCustomException;
    public LoginResponse loginGoogle(LoginRequest loginReq) throws BaseCustomException;
    public boolean signUpAccountByGoogle(LoginRequest loginRequest) throws BaseCustomException;
    public boolean signUp(SignupRequest signUpReq) throws BaseCustomException;
}