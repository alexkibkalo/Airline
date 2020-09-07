package com.fly.validation.board;

import com.fly.persistence.entity.board.Board;
import com.fly.service.actor.ActorService;

public interface BoardValidationService extends ActorService {

    void validateCreation(Board board);

    void validateDeleting();

    void validateUpdating(Board board);

//    void validateUpdatingRegistration(Board board, BoardUpdateRegistrationDto dto);

//    void validateExistingBoardByRegistration(String registration);

}
