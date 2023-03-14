package com.oxigent.app.exception;

import org.springframework.http.HttpStatus;

public class MyAppException extends RuntimeException {
	
	private HttpStatus status;

    public MyAppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
