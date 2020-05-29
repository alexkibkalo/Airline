package com.fly.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "INVALID_PASSWORD")
public class UserPasswordException extends RuntimeException {

    public UserPasswordException() {
        super(HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }

    public UserPasswordException(String message) {
        super(message);
    }
}
