package com.mobile.bookstore.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private int id;
    private String username;
    private String role;
    private String fullName;
    private String urlImg;
    private String qrCode;
    private boolean status;
}
