package com.fly.controller;

import com.fly.exception.UserNotFoundException;
import com.fly.service.authorization.AuthorizationService;
import com.fly.transport.dto.authorization.LoginDto;
import com.fly.transport.dto.token.TokenOutcomeDto;
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

    @PostMapping(value = "login", produces = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public TokenOutcomeDto login(@RequestBody @Valid LoginDto dto) throws UserNotFoundException {
        return authorizationService.login(dto);
    }
}
