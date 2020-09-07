package com.fly.controller.board;

import com.fly.persistence.entity.board.Board;
import com.fly.service.board.BoardService;
import com.fly.transport.dto.board.BoardCreateDto;
import com.fly.transport.dto.board.BoardOutcomeDto;
import com.fly.transport.dto.board.BoardUpdateDto;
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
@Api(value = "BoardController", description = "REST API for Board", tags = {"Board"})
@RequestMapping(path = "boards", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class BoardController {

    private BoardService boardService;

    @ApiOperation(value = "Finding boards", notes = "ADMIN, MANAGER", nickname = "findAllBoards")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found"),
            @ApiResponse(code = 400, message = "Not valid dto"),
            @ApiResponse(code = 401, message = "Not correct token")
    })
    @ResponseStatus(code = HttpStatus.OK)
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @GetMapping
    public List<BoardOutcomeDto> getAll() {
        return boardService.getAll();
    }

    @ApiOperation(value = "Create a board", notes = "ADMIN, MANAGER", nickname = "createBoard")
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
    public Long create(@RequestBody @Valid BoardCreateDto dto) {
        return boardService.create(dto).getId();
    }

    @ApiOperation(value = "Update a board", notes = "ADMIN, MANAGER", nickname = "updateBoard")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update accepted"),
            @ApiResponse(code = 400, message = "Not valid dto"),
            @ApiResponse(code = 401, message = "Not correct token"),
            @ApiResponse(code = 403, message = "User doesn't have permission"),
            @ApiResponse(code = 404, message = "Not correct data"),
    })
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PutMapping("{id}")
    public Board update(@PathVariable Long id, @RequestBody @Valid BoardUpdateDto dto) {
        return boardService.update(id, dto);
    }

    @ApiOperation(value = "Delete a board by id", notes = "ADMIN, MANAGER", nickname = "deleteBoard")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleted successfully"),
            @ApiResponse(code = 401, message = "Not correct token"),
            @ApiResponse(code = 403, message = "User doesn't have permission"),
            @ApiResponse(code = 404, message = "Not correct data"),
    })
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @DeleteMapping("{id}")
    public Long delete (@PathVariable Long id) {
        return boardService.delete(id);
    }


//    @ApiOperation(value = "Update a board's registration", notes = "ADMIN, MANAGER", nickname = "updateRegistration")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Update accepted"),
//            @ApiResponse(code = 400, message = "Not valid dto"),
//            @ApiResponse(code = 401, message = "Not correct token"),
//            @ApiResponse(code = 403, message = "User doesn't have permission"),
//            @ApiResponse(code = 404, message = "Not correct data"),
//    })
//    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
//    @PatchMapping("registration")
//    public Long updateRegistration(@RequestBody @Valid BoardUpdateRegistrationDto dto) {
//        return boardService.update(dto);
//    }

}
