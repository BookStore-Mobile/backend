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
public class AccountResponse {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String qrCode;
    private boolean status;
}
