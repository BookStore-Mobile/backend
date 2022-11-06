package com.mobile.bookstore.exception.custom;

import com.mobile.bookstore.exception.CustomError;

public class CustomDuplicateFieldException  extends BaseCustomException{

    public CustomDuplicateFieldException(CustomError customError) {
        super(customError);
    }
    
}
