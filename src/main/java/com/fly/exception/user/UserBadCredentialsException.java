package com.fly.exception.user;

import com.fly.exception.standart.UnauthorizedException;

public class UserBadCredentialsException extends UnauthorizedException {

    public UserBadCredentialsException() {
        super("Invalid email or password");
    }

    public UserBadCredentialsException(String message) {
        super(message);
    }
}
