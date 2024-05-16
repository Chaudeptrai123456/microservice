package com.example.serverUser.Error;

import lombok.Data;

@Data
public class ErrorResponse extends RuntimeException{
    private String message;

    public ErrorResponse( String message) {
        super(message);
        this.message = message;
    }
}
