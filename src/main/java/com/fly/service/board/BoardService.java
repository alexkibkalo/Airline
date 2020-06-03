package com.fly.service.board;

import com.fly.persistence.entity.board.Board;
import com.fly.service.actor.ActorService;
import com.fly.transport.dto.board.*;

import java.util.List;
import java.util.Optional;

public interface BoardService extends ActorService {

    Board create(BoardCreateDto dto);

    BoardOutcomeDto findByRegistration(String registration);

    Board findByIdUnsafe(Long id);

    void delete(Long id);

    Long update(Long id, BoardUpdateDto dto);

    Long update(BoardUpdateRegistrationDto dto);

    boolean existByRegistration(String registration);

    List<BoardOutcomeDto> getAll();

    Long updatePhoto(Long id, BoardPhotoUpdateDto dto);
}
