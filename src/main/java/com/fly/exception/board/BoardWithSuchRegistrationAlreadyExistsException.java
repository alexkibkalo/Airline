package com.fly.exception.board;

import com.fly.exception.standard.BadRequestException;

public class BoardWithSuchRegistrationAlreadyExistsException extends BadRequestException {

    public BoardWithSuchRegistrationAlreadyExistsException() {
        super("Board with such registration already exist");
    }

    public BoardWithSuchRegistrationAlreadyExistsException(String message) {
        super(message);
    }
}
