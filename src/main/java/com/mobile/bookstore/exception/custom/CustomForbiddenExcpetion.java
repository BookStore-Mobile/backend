package com.mobile.bookstore.exception.custom;

import com.mobile.bookstore.exception.CustomError;

public class CustomForbiddenExcpetion extends BaseCustomException {

    public CustomForbiddenExcpetion(CustomError customError) {
        super(customError);
    }
    
}
