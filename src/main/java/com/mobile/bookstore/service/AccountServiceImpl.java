package com.mobile.bookstore.service;

import java.util.List;

import com.mobile.bookstore.entity.Account;
import com.mobile.bookstore.entity.Candicate;
import com.mobile.bookstore.exception.custom.BaseCustomException;
import com.mobile.bookstore.exception.custom.CustomDuplicateFieldException;
import com.mobile.bookstore.exception.custom.CustomUnauthorizedException;
import com.mobile.bookstore.model.request.SignupRequest;
import com.mobile.bookstore.model.response.AccountResponse;
import com.mobile.bookstore.repo.AccountRepo;

public class AccountServiceImpl implements AccountService {
    private AccountRepo accountRepo;

    @Override
    public Account findAccountByUsername(String username) {
        Account account  = accountRepo.findByUsername(username) ;
		if(account != null){
			return account;
		}
		return null;
    }

    @Override
    public List<Account> getListAccount() {
        return accountRepo.findAll();
    }

    @Override
    public AccountResponse createNewAccount(SignupRequest signupRequest)
            throws CustomDuplicateFieldException, CustomUnauthorizedException {
        Candicate candicate = new Candicate();
        candicate.setUsername(signupRequest.getUsername());
        candicate.setPassword(signupRequest.getPassword());
        candicate.setFullname(signupRequest.getFullname());
        return null;
    }

    @Override
    public AccountResponse updateAccount(int id, SignupRequest signupRequest) throws BaseCustomException {
        Candicate candicate = new Candicate();
        candicate.setFullname(signupRequest.getFullname());
        candicate.setPassword(signupRequest.getPassword());
        return null;
    }

    @Override
    public AccountResponse getAccountByID(int id) {
        Account account  = accountRepo.findById(id) ;
		if(account == null){
			return null;
		}
		return accountToAccountResponse(account);
    }

    public static AccountResponse accountToAccountResponse(Account account) {
		AccountResponse accountResponse = AccountResponse.builder().id(account.getId()).username(account.getUsername())
				.status(account.isStatus()).password(account.getPassword()).fullname(account.getFullname()).
                qrCode(account.getQrcode()).build();
		return accountResponse;

	}
}
