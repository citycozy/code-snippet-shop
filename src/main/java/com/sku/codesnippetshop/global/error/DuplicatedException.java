package com.sku.codesnippetshop.global.error;


import com.sku.codesnippetshop.global.response.ResponseStatus;

public class DuplicatedException extends BusinessLogicException{
    public DuplicatedException(ResponseStatus responseStatus) {
        super(responseStatus);
    }

    public DuplicatedException(String message) {
        super(message);
    }
}