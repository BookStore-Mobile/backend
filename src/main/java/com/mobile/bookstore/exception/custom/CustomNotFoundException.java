package com.mobile.bookstore.exception.custom;

import com.mobile.bookstore.exception.CustomError;

public class CustomNotFoundException extends BaseCustomException {

    public CustomNotFoundException(CustomError customError) {
        super(customError);
    }
    
}
