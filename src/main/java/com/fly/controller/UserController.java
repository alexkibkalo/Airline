package com.fly.controller;

import com.fly.service.user.UserService;
import com.fly.transport.dto.user.UserOutcomeDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Setter(onMethod_ = @Autowired)
@RequestMapping(path = "users", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UserController {

    private UserService userService;

    @ApiOperation(notes = "ADMIN,MANAGER,USER", value = "getAll", nickname = "findAllUsers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Not valid dto"),
            @ApiResponse(code = 401, message = "Not correct token"),
            @ApiResponse(code = 403, message = "User doesn't have permission"),
            @ApiResponse(code = 404, message = "Not correct data"),
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'USER')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserOutcomeDto> findAll() {
        return userService.findAll();
    }
}
