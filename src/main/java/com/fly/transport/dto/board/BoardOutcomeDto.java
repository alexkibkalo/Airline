package com.fly.transport.dto.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BoardOutcomeDto {

    private String aircraft;

    private String registration;

    private String country;

    private String issue;

    private String airline;

    private byte[] photo;

    private Integer capacity;

    private boolean available;
}
