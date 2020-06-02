package com.fly.transport.dto.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardOutcomeDto {

    private String aircraft;

    private String registration;

    private String country;

    private String issue;

    private String airline;

    private byte[] photo;

    private Integer capacity;
}
