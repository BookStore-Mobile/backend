package com.mobile.bookstore.exception.custom;

import com.mobile.bookstore.exception.CustomError;

public class CustomInternalServerException extends BaseCustomException {

    public CustomInternalServerException(CustomError customError) {
        super(customError);
    }
    
}
