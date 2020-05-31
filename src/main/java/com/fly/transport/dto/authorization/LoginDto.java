package com.fly.transport.dto.authorization;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginDto {

    @Email
    @NotBlank
    @NotNull
    @ApiModelProperty(value = "airlinea@gmail.com")
    private String email;

    @NotBlank
    @NotNull
    @ApiModelProperty(value = "111111")
    private String password;
}
