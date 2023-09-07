package com.jwtpractise.exception;

import lombok.Getter;

@Getter
public class ApiInputException extends RuntimeException{
    private Object data;
    private String message;
    public ApiInputException(Object data, String message){
        this.message = message;
        this.data = data;
    }
}
