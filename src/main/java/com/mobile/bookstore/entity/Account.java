package com.mobile.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int id;
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
    @Column(name = "role", nullable = false, length = 15)
    private String role;
    @Column(name = "imageUrl", length = 150)
    private String imageUrl;
    
}
