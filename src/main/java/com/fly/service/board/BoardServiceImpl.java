package com.fly.service.board;

import com.fly.exception.board.BoardNotFoundException;
import com.fly.persistence.entity.board.Board;
import com.fly.persistence.repository.BoardRepository;
import com.fly.transport.dto.board.*;
import com.fly.transport.mapper.board.BoardMapper;
import com.fly.validation.board.BoardValidationService;
import com.fly.validation.user.UserValidationService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Setter(onMethod_ = @Autowired)
public class BoardServiceImpl implements BoardService{

    private BoardRepository boardRepository;
    private BoardMapper boardMapper;
    private BoardValidationService boardValidationService;

    @Override
    public Board create(BoardCreateDto dto) {
        Board board = boardMapper.toEntity(dto);
        boardValidationService.validateCreation(board);
        return boardRepository.save(board);
    }

    @Override
    @Transactional(readOnly = true)
    public BoardOutcomeDto findByRegistration(String registration) {

        Board board = boardRepository.findByRegistration(registration).orElseThrow(BoardNotFoundException::new);

        return boardMapper.toDto(board);
    }

    @Override
    @Transactional(readOnly = true)
    public Board findByIdUnsafe(Long id) {
         return boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        boardValidationService.validateDeleting();

        boardRepository.deleteById(id);
    }

    @Override
    public Long update(Long id, BoardUpdateDto dto) {
        Board board = findByIdUnsafe(id);

        boardValidationService.validateUpdating(board);

        return boardMapper.toEntity(dto, board).getId();
    }

    @Override
    public Long update(BoardUpdateRegistrationDto dto) {
        boardValidationService.validateExistingBoardByRegistration(dto.getOldRegistration());
        Board board = boardRepository.findByRegistration(dto.getOldRegistration()).get();
        boardValidationService.validateUpdatingRegistration(board, dto);
        board.setRegistration(dto.getNewRegistration());

        return board.getId();
    }

    @Transactional
    @Override
    public List<BoardOutcomeDto> getAll() {
        return boardRepository.findAll().stream()
                .map(boardMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existByRegistration(String registration) {
        return boardRepository.existsByRegistration(registration);
    }

    @Override
    public Long updatePhoto(Long id, BoardPhotoUpdateDto dto) {
        Board board = findByIdUnsafe(id);
        boardValidationService.validateUpdating(board);
        board.setPhoto(dto.getPhoto().getBytes());
        return board.getId();
    }
}
