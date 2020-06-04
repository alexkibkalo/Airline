package com.fly.transport.dto.route;

import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class RouteOutcomeDto {

    private String fromCity;

    private String fromAirport;

    private String fromAirportUID;

    private String toCity;

    private String toAirport;

    private String toAirportUID;

    private Instant departureDate;

    private Instant returnDate;
}
