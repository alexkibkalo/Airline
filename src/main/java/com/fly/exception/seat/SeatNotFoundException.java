package com.fly.exception.seat;

import com.fly.exception.standard.NotFoundException;

public class SeatNotFoundException extends NotFoundException {

    public SeatNotFoundException() {
        super("Seat not found");
    }

    public SeatNotFoundException(String message) {
        super(message);
    }
}
