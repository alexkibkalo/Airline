package com.fly.transport.mapper.board;

import com.fly.persistence.entity.board.Board;
import com.fly.transport.dto.board.BoardCreateDto;
import com.fly.transport.dto.board.BoardOutcomeDto;
import com.fly.transport.dto.board.BoardUpdateDto;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
@Setter(onMethod_ = @Autowired)
public abstract class BoardMapper {

    public abstract Board toEntity(BoardCreateDto dto);

    public abstract Board toEntity(BoardUpdateDto dto);

    public abstract BoardOutcomeDto toDto(Board board);

    public abstract Board toEntity(BoardUpdateDto dto, @MappingTarget Board board);

}
