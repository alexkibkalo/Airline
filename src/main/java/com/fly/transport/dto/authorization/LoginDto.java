package com.fly.transport.dto.authorization;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginDto {

    @Email
    @NotBlank
    @ApiModelProperty(example = "airline@gmail.com", required = true)
    private String email;

    @NotBlank
    @ApiModelProperty(example = "111111", required = true)
    private String password;
}
