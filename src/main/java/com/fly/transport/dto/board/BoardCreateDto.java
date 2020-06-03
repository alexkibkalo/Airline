package com.fly.transport.dto.board;

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
public class BoardCreateDto {

    @NotBlank
    @NotNull
    private String aircraft;

    @NotBlank
    @NotNull
    private String registration;

    @NotBlank
    @NotNull
    private String country;

    @NotBlank
    @NotNull
    private String issue;

    @NotBlank
    @NotNull
    private String airline;

    private byte[] photo;

    @NotNull
    private Integer capacity;

    @NotNull
    private boolean available;

}
