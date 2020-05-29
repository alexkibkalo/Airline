package com.fly.exception.user;

import com.fly.exception.standart.UnauthorizedException;

public class UserInvalidEmailException extends UnauthorizedException {

    public UserInvalidEmailException() {
        super("Invalid email");
    }

    public UserInvalidEmailException(String message) {
        super(message);
    }
}
