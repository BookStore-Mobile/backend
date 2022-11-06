package com.mobile.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Account {
    @Id
    @Column(name = "account_id", nullable = false)
    private String accountId;
    @Column(name = "username",unique = true, nullable = false, length = 50)
    private String username;
    @Column(name = "password", length = 50)
    private String password;
    @Column(name = "fullname", length = 50)
    private String fullname;
    @Column(name = "qrcode", length = 50)
    private String qrcode;
    @Column(name = "status", nullable = false)
    private boolean status;
}
