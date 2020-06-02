package com.fly.exception.board;

import com.fly.exception.standard.NotFoundException;

public class BoardNotFoundException extends NotFoundException {
    public BoardNotFoundException() {
        super("Board not found");
    }

    public BoardNotFoundException(String message) {
        super(message);
    }
}
