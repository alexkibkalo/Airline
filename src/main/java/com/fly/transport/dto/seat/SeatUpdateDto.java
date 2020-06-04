package com.fly.transport.dto.seat;

import com.fly.persistence.entity.seat.TypeSeat;
import com.fly.validation.typeseat.TypeSeatSubset;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SeatUpdateDto {

    @NotNull
    @NotBlank
    private Integer row;

    @NotNull
    @NotBlank
    private String letter;

    @NotNull
    @TypeSeatSubset(anyOf = {TypeSeat.BUSINESS, TypeSeat.ECONOMY, TypeSeat.EMERGENCY})
    private TypeSeat typeSeat;
}
