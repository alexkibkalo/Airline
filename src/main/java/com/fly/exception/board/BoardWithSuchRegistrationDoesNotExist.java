package com.fly.exception.board;

import com.fly.exception.standard.BadRequestException;

public class BoardWithSuchRegistrationDoesNotExist extends BadRequestException {

    public BoardWithSuchRegistrationDoesNotExist() {
        super("Registration with such email does not exists");
    }

    public BoardWithSuchRegistrationDoesNotExist(String message) {
        super(message);
    }
}
