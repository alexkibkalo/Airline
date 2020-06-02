package com.fly.controller.board;

import com.fly.persistence.entity.board.Board;
import com.fly.service.board.BoardService;
import com.fly.transport.dto.board.BoardCreateDto;
import com.fly.transport.dto.board.BoardOutcomeDto;
import com.fly.transport.dto.board.BoardUpdateDto;
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

@Setter(onMethod_ = @Autowired)
@RequestMapping(path = "boards", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class BoardController {

    private BoardService boardService;

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
    public void delete (@PathVariable Long id) {
        boardService.delete(id);
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
    public Long update(@PathVariable Long id, @RequestBody @Valid BoardUpdateDto dto){
        return boardService.update(id, dto).getId();
    }

    @ApiOperation(value = "Finding board", notes = "ADMIN, MANAGER", nickname = "findBoardByRegistration")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found"),
            @ApiResponse(code = 400, message = "Not valid dto"),
            @ApiResponse(code = 401, message = "Not correct token"),
    })
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/registration/{registration}")
    public BoardOutcomeDto findByRegistration(@PathVariable String registration) {
        return boardService.findByRegistration(registration);
    }

    @ApiOperation(value = "Finding board", notes = "ADMIN, MANAGER", nickname = "findBoardById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found"),
            @ApiResponse(code = 400, message = "Not valid dto"),
            @ApiResponse(code = 401, message = "Not correct token"),
    })
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("{id}")
    public BoardOutcomeDto findById(@PathVariable Long id){
        return boardService.findById(id);
    }
}
