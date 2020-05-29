package com.fly.transport.dto.user;

import com.fly.persistence.entity.user.UserRole;
import com.fly.validation.userrole.UserRoleSubset;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {

    @NotBlank
    @Email
    private String email;

    @NotNull
    @UserRoleSubset(anyOf = {UserRole.ADMIN, UserRole.USER})
    private UserRole userRole;

}
