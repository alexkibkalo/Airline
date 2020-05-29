package com.fly.transport.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserUpdateDto {

    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String middleName;

    @NotBlank
    @NotNull
    private String lastName;

    @NotBlank
    @NotNull
    private String phone;
}
