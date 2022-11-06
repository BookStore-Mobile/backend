package com.mobile.bookstore.exception.custom;

import com.mobile.bookstore.exception.CustomError;

public class CustomUnauthorizedException extends BaseCustomException {

    public CustomUnauthorizedException(CustomError customError) {
        super(customError);
    }
    
}
