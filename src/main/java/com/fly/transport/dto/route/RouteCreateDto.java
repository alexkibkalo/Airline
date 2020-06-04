package com.fly.transport.dto.route;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteCreateDto {

    @NotNull
    @NotBlank
    private String fromCity;

    @NotNull
    @NotBlank
    private String fromAirport;

    @NotNull
    @NotBlank
    private String fromAirportUID;

    @NotNull
    @NotBlank
    private String toCity;

    @NotNull
    @NotBlank
    private String toAirport;

    @NotNull
    @NotBlank
    private String toAirportUID;

    @NotNull
    private Instant departureDate;

    @NotNull
    private Instant returnDate;
}
