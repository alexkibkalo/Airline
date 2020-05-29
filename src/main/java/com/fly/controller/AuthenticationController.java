package com.fly.controller;

import com.fly.service.authorization.AuthorizationService;
import com.fly.transport.dto.authorization.LoginDto;
import com.fly.transport.dto.token.TokenOutcomeDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Setter(onMethod_ = @Autowired)
@RequestMapping(path = "authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AuthenticationController {

    private AuthorizationService authorizationService;

    @ApiOperation(notes = "INCOGNITO", value = "login", nickname = "login")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Successful"),
            @ApiResponse(code = 400, message = "Not valid dto"),
            @ApiResponse(code = 401, message = "Not correct token"),
            @ApiResponse(code = 403, message = "User doesn't have permission"),
            @ApiResponse(code = 404, message = "User is deleted"),
    })
    @PostMapping(value = "login", produces = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public TokenOutcomeDto login(@RequestBody @Valid LoginDto dto) {
        return authorizationService.login(dto);
    }

    @ApiOperation(notes = "AUTHORIZED_ROLE", value = "logout", nickname = "logout")
    @ApiResponses(value = {
            @ApiResponse(code = 205, message = "Successful"),
            @ApiResponse(code = 401, message = "Not correct token"),
            @ApiResponse(code = 403, message = "User doesn't have permission"),
    })
    @PostMapping("logout")
    @ResponseStatus(code = HttpStatus.RESET_CONTENT)
    public void logout() {
        authorizationService.logout();
    }
}
