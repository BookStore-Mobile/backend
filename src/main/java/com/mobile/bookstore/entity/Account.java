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
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "username",unique = true, nullable = false, length = 50)
    private String username;
    @Column(name = "password", length = 50)
    private String password;
    @Column(name = "fullname", length = 50)
    private String fullname;
    @Column(name = "image_url", length = 100)
    private String imageUrl;
    @Column(name = "role", length = 10)
    private String role;
    @Column(name = "qrcode", length = 50)
    private String qrcode;
    @Column(name = "status", nullable = false)
    private boolean status;
}
