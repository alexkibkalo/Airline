package com.fly.validation.board;

import com.fly.exception.board.BoardWithSuchRegistrationAlreadyExistsException;
import com.fly.exception.standard.ForbiddenException;
import com.fly.persistence.entity.board.Board;
import com.fly.persistence.entity.user.User;
import com.fly.service.board.BoardService;
import com.fly.service.user.role.RoleUtils;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter(onMethod_ = @Autowired)
public class BoardValidationServiceImpl implements BoardValidationService {

    private BoardService boardService;

    @Override
    public void validateCreation(Board board) {
        validateCreationUpdatingDeletingPermission();
        validateUniqueRegistration(board.getRegistration());
    }

    @Override
    public void validateDeleting() {
        validateCreationUpdatingDeletingPermission();
    }

    @Override
    public void validateUpdating(Board board) {
        validateCreationUpdatingDeletingPermission();
    }

//    @Override
//    public void validateUpdatingRegistration(Board board, BoardUpdateRegistrationDto dto){
//        validateCreationUpdatingDeletingPermission();
//        validateOldAndNewRegistrationNotEqual(dto);
//        validateOldRegistration(dto);
//        validateUniqueRegistration(dto.getNewRegistration());
//    }

//    @Override
//    public void validateExistingBoardByRegistration(String registration) {
//        if(!boardService.existByRegistration(registration)){
//            throw new BoardWithSuchRegistrationDoesNotExist();
//        }
//    }

//    private void boardCalculateYearOfIssue(Board dto) {
//        LocalDate now = LocalDate.now();
//        LocalDate issue = LocalDate.of(Integer.parseInt(dto.getIssue()),1,1);
//
//        int capacityOfBoard = Period.between(issue, now).getYears();
//
//        dto.setCapacity(capacityOfBoard);
//    }

    private void validateCreationUpdatingDeletingPermission() {
        User actor = getActorFromContext();

        if(!RoleUtils.isAdmin(actor) && !RoleUtils.isManager(actor)){
            throw new ForbiddenException();
        }
    }

    private void validateUniqueRegistration(String registration) {
        if(boardService.existByRegistration(registration)){
            throw new BoardWithSuchRegistrationAlreadyExistsException();
        }
    }

//    private void validateOldAndNewRegistrationNotEqual(BoardUpdateRegistrationDto dto) {
//        if(dto.getNewRegistration().equals(dto.getOldRegistration())){
//            throw new BadRequestException("New registration must be different from old");
//        }
//    }
//
//    private void validateOldRegistration(BoardUpdateRegistrationDto dto) {
//        if(!boardService.existByRegistration(dto.getOldRegistration())){
//            throw new BoardWithSuchRegistrationDoesNotExist();
//        }
//    }

}
