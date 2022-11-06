package com.mobile.bookstore.exception.custom;

import com.mobile.bookstore.exception.CustomError;

public class CustomBadRequestException extends BaseCustomException {

    public CustomBadRequestException(CustomError customError) {
        super(customError);
    }
    
}
