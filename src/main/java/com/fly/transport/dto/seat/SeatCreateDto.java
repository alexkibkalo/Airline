package com.fly.transport.dto.seat;

import com.fly.persistence.entity.seat.TypeSeat;
import com.fly.validation.typeseat.TypeSeatSubset;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatCreateDto {

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
