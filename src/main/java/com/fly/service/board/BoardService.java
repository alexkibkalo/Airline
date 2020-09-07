package com.fly.service.board;

import com.fly.persistence.entity.board.Board;
import com.fly.service.actor.ActorService;
import com.fly.transport.dto.board.BoardCreateDto;
import com.fly.transport.dto.board.BoardOutcomeDto;
import com.fly.transport.dto.board.BoardUpdateDto;

import java.util.List;

public interface BoardService extends ActorService {

    Board create(BoardCreateDto dto);

    Board update(Long id, BoardUpdateDto dto);

    Long delete(Long id);

    Board findByIdUnsafe(Long id);

    List<BoardOutcomeDto> getAll();

    boolean existByRegistration(String registration);

//    Board update(BoardUpdateRegistrationDto dto);

}
