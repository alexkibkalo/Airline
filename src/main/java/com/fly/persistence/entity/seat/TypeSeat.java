package com.fly.persistence.entity.seat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeSeat {
    ECONOMY(0.3),
    BUSINESS(0.3),
    EMERGENCY(0.3);

    private final Double coefficient;
}
