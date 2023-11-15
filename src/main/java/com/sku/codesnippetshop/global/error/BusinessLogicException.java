package com.sku.codesnippetshop.global.error;


import com.sku.codesnippetshop.global.response.ResponseStatus;

public class BusinessLogicException extends RuntimeException{
    private ResponseStatus responseStatus;

    public BusinessLogicException(ResponseStatus responseStatus){
        super(responseStatus.getMessage());
        this.responseStatus = responseStatus;
    }

    public BusinessLogicException(String message){
        super(message);
    }
}