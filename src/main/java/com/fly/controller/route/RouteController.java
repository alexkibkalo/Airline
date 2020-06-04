package com.fly.controller.route;

import com.fly.service.route.RouteService;
import com.fly.transport.dto.route.RouteCreateDto;
import com.fly.transport.dto.route.RouteOutcomeDto;
import com.fly.transport.dto.route.RouteUpdateDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Setter(onMethod_ = @Autowired)
@Api(value = "RouteController", description = "REST API for Route", tags = {"Route"})
@RequestMapping(path = "route", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class RouteController {

    private RouteService routeService;

    @ApiOperation(value = "Create a route", notes = "ADMIN, MANAGER", nickname = "createRoute")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created"),
            @ApiResponse(code = 400, message = "Not valid dto"),
            @ApiResponse(code = 401, message = "Not correct token"),
            @ApiResponse(code = 403, message = "User doesn't have permission"),
            @ApiResponse(code = 404, message = "Not correct data"),
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long create(@RequestBody @Valid RouteCreateDto dto){
        return routeService.create(dto).getId();
    }

    @ApiOperation(value = "Delete a route by id", notes = "ADMIN, MANAGER", nickname = "deleteRoute")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleted successfully"),
            @ApiResponse(code = 401, message = "Not correct token"),
            @ApiResponse(code = 403, message = "User doesn't have permission"),
            @ApiResponse(code = 404, message = "Not correct data"),
    })
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        routeService.delete(id);
    }

    @ApiOperation(value = "Recovery a route by id", notes = "ADMIN, MANAGER", nickname = "recoveryRoute")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleted successfully"),
            @ApiResponse(code = 401, message = "Not correct token"),
            @ApiResponse(code = 403, message = "User doesn't have permission"),
            @ApiResponse(code = 404, message = "Not correct data"),
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("{id}")
    public Long recovery(@PathVariable Long id) {
        return routeService.recovery(id);
    }

    @ApiOperation(value = "Update a route", notes = "ADMIN, MANAGER", nickname = "updateRoute")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update accepted"),
            @ApiResponse(code = 400, message = "Not valid dto"),
            @ApiResponse(code = 401, message = "Not correct token"),
            @ApiResponse(code = 403, message = "User doesn't have permission"),
            @ApiResponse(code = 404, message = "Not correct data"),
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{id}")
    public Long update(@PathVariable Long id, @RequestBody @Valid RouteUpdateDto dto){
        return routeService.update(id, dto);
    }

    @ApiOperation(value = "Finding routes", notes = "ADMIN, MANAGER, USER", nickname = "findAllRoutes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found"),
            @ApiResponse(code = 400, message = "Not valid dto"),
            @ApiResponse(code = 401, message = "Not correct token"),
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'USER')")
    @GetMapping()
    public List<RouteOutcomeDto> getAll() {
        return routeService.getAll();
    }
}
