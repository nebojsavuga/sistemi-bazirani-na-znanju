package com.ftn.sbnz.service.exceptions;

public class BadRequestException extends RuntimeException{
    private String message;

    public BadRequestException() {}

    public BadRequestException(String msg)
    {
        super(msg);
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
