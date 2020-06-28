package com.example.springbootonline2.exception;

public class UnProcessableException extends RuntimeException {
    public UnProcessableException(String message) {
        super(message);
    }
}
