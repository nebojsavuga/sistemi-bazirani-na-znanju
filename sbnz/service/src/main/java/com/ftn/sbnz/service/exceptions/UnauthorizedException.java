package com.ftn.sbnz.service.exceptions;

public class UnauthorizedException extends RuntimeException{

    private String message;

    public UnauthorizedException() {}

    public UnauthorizedException(String msg)
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
