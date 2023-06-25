package com.tesco.web.test.service.exception;

public class ClientResponseNotSuccessfulException extends RuntimeException {
    public ClientResponseNotSuccessfulException(String message) {
        super(message);
    }
}
