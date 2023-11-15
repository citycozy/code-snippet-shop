package com.sku.codesnippetshop.global.error;


import com.sku.codesnippetshop.global.response.ResponseStatus;

public class NotFoundException extends BusinessLogicException{
    public NotFoundException(ResponseStatus responseStatus) {
        super(responseStatus);
    }
    public NotFoundException(String message) {
        super(message);
    }
}