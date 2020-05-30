package com.fly.persistence.entity.board;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public enum BoardStatus {
    UNAVAILABLE(Instant.now(), Instant.now()),
    AVAILABLE(Instant.now(), Instant.now());

    Instant from;
    Instant to;
}
