package com.fly.service.board;

import com.fly.persistence.entity.board.Board;
import com.fly.service.actor.ActorService;
import com.fly.transport.dto.board.BoardCreateDto;
import com.fly.transport.dto.board.BoardOutcomeDto;
import com.fly.transport.dto.board.BoardUpdateDto;

import java.util.Optional;

public interface BoardService extends ActorService {

    Board create(BoardCreateDto dto);

    BoardOutcomeDto findByRegistration(String registration);

    BoardOutcomeDto findById(Long id);

    void delete(Long id);

    Board update(Long id, BoardUpdateDto dto);
}
