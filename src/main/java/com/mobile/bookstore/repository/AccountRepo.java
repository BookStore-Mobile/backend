package com.mobile.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.bookstore.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository <Account,String> {
	public Account findByUsername(String username);
    public Account findById(int id);
    
}
