package com.fly.transport.dto.seat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeatOutcomeDto {

    private Integer row;

    private String letter;

    private String typeSeat;

}
