package com.mobile.bookstore.utils;

import org.springframework.stereotype.Component;

import com.mobile.bookstore.entity.Account;
import com.mobile.bookstore.repository.AccountRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class BookUtil {
	private final AccountRepo accRepo;
	
	public boolean checkRoleAccount(AccountRole role, int accountId) {
		if(role == null) return false;
		Account acc = accRepo.findById(accountId);
		if(acc != null) {
			if(acc.getRole().equalsIgnoreCase(role.toString())) {
				return true;
			}
		}
		return false;
	}
}
