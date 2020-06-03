package com.fly.transport.dto.board;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BoardUpdateRegistrationDto {

    @NotNull
    @NotBlank
    private String oldRegistration;

    @NotNull
    @NotBlank
    private String newRegistration;
}
