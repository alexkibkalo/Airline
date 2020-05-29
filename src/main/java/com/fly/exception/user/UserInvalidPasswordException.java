package com.fly.exception.user;

import com.fly.exception.standart.UnauthorizedException;

public class UserInvalidPasswordException extends UnauthorizedException {

    public UserInvalidPasswordException() {
        super("Invalid password");
    }

    public UserInvalidPasswordException(String message) {
        super(message);
    }
}
