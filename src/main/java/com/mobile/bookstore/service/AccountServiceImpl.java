package com.mobile.bookstore.service;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mobile.bookstore.entity.Account;
import com.mobile.bookstore.exception.CustomError;
import com.mobile.bookstore.exception.custom.BaseCustomException;
import com.mobile.bookstore.exception.custom.CustomDuplicateFieldException;
import com.mobile.bookstore.exception.custom.CustomNotFoundException;
import com.mobile.bookstore.exception.custom.CustomUnauthorizedException;
import com.mobile.bookstore.model.GoogleAccDTO;
import com.mobile.bookstore.model.ObjectMapper;
import com.mobile.bookstore.model.request.CustomLoginRequest;
import com.mobile.bookstore.model.request.LoginRequest;
import com.mobile.bookstore.model.request.SignupRequest;
import com.mobile.bookstore.model.response.AccountResponse;
import com.mobile.bookstore.model.response.LoginResponse;
import com.mobile.bookstore.repository.AccountRepo;
import com.mobile.bookstore.utils.AccountRole;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;

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
        Account acc = new Account();
        acc.setUsername(signupRequest.getUsername());
        acc.setPassword(signupRequest.getPassword());
        acc.setFullname(signupRequest.getFullname());
        return ObjectMapper.accountToAccountResponse(accountRepo.save(acc));
    }

    @Override
    public AccountResponse updateAccount(int id, SignupRequest signupRequest) throws BaseCustomException {
    	Account acc = new Account();
    	acc.setUsername(signupRequest.getUsername());
        acc.setPassword(signupRequest.getPassword());
        return ObjectMapper.accountToAccountResponse(accountRepo.save(acc));
    }

    @Override
    public AccountResponse getAccountByID(int id) {
        Account account  = accountRepo.findById(id) ;
		if(account == null){
			return null;
		}
		return ObjectMapper.accountToAccountResponse(account);
    }



	@Override
	public LoginResponse login(CustomLoginRequest customLoginReq) throws BaseCustomException{
		if(customLoginReq == null) throw new CustomNotFoundException(CustomError.builder().code("400").message("Bad Request").build());
		Account account = accountRepo.findByUsername(customLoginReq.getUsername());
		if(account != null) {
			if(account.getPassword().equals(customLoginReq.getPassword())) {
				LoginResponse res = ObjectMapper.accountToLoginResponse(account);
				if(res!= null) {
					return res;
				} else throw new CustomNotFoundException(
						CustomError.builder().code("404").message("DB Add Failed!").build());
			} else throw new CustomNotFoundException(CustomError.builder().code("403")
					.message("Wrong Username or Password...").build());
		} else throw new CustomNotFoundException(
				CustomError.builder().code("404").message("Not Found Account!").build());
	}

	@Override
	public LoginResponse loginGoogle(LoginRequest loginReq) throws BaseCustomException{
		if(loginReq == null) throw new CustomNotFoundException(CustomError.builder().code("400").message("Bad Request").build());
		String[] base64EncodedSegments = loginReq.getAuthToken().split("\\.");

		String base64EncodedHeader = base64EncodedSegments[0];
		String base64EncodedClaims = base64EncodedSegments[1];
		Base64.Decoder decoder = Base64.getUrlDecoder();

		String header = new String(decoder.decode(base64EncodedHeader));
		String payload = new String(decoder.decode(base64EncodedClaims));
		Gson gson = new Gson();
		GoogleAccDTO googleAcc = gson.fromJson(payload, GoogleAccDTO.class);

		LoginResponse loginResponse = null;
		Account account = accountRepo.findByUsername(googleAcc.getEmail());
		String roleName = null;
		if (account != null) {
			return ObjectMapper.accountToLoginResponse(account);
		} else throw new CustomNotFoundException(CustomError.builder().code("403")
				.message("Wrong Username or Password...").build());
	}

	@Override
	public boolean signUpAccountByGoogle(LoginRequest loginRequest) throws BaseCustomException{
		if(loginRequest == null) throw new CustomNotFoundException(CustomError.builder().code("400").message("Bad Request").build());
		String[] base64EncodedSegments = loginRequest.getAuthToken().split("\\.");

		String base64EncodedHeader = base64EncodedSegments[0];
		String base64EncodedClaims = base64EncodedSegments[1];
		Base64.Decoder decoder = Base64.getUrlDecoder();

		String header = new String(decoder.decode(base64EncodedHeader));
		String payload = new String(decoder.decode(base64EncodedClaims));
		Gson gson = new Gson();
		GoogleAccDTO googleAcc = gson.fromJson(payload, GoogleAccDTO.class);
		Account nAcc = new Account();
		nAcc.setFullname(googleAcc.getName());
		nAcc.setImageUrl(googleAcc.getPicture());
		nAcc.setStatus(true);
		nAcc.setRole(AccountRole.User.toString());
		nAcc.setUsername(googleAcc.getEmail());
		if(accountRepo.save(nAcc) != null) {
			return true;
		} else throw new CustomNotFoundException(
				CustomError.builder().code("404").message("DB Add Failed!").build());
	}

	@Override
	public boolean signUp(SignupRequest signUpReq) throws BaseCustomException{
		if(signUpReq == null) throw new CustomNotFoundException(CustomError.builder().code("400").message("Bad Request").build());
		Account acc = new Account();
        acc.setUsername(signUpReq.getUsername());
        acc.setPassword(signUpReq.getPassword());
        acc.setFullname(signUpReq.getFullname());
        acc.setStatus(true);
        acc.setRole(AccountRole.User.toString());
        if(accountRepo.save(acc) != null) {
			return true;
		} else throw new CustomNotFoundException(
				CustomError.builder().code("404").message("DB Add Failed!").build());
	}
	

}
