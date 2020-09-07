package com.fly.service.board;

import com.fly.exception.board.BoardNotFoundException;
import com.fly.persistence.entity.board.Board;
import com.fly.persistence.repository.BoardRepository;
import com.fly.transport.dto.board.BoardCreateDto;
import com.fly.transport.dto.board.BoardOutcomeDto;
import com.fly.transport.dto.board.BoardUpdateDto;
import com.fly.transport.mapper.board.BoardMapper;
import com.fly.validation.board.BoardValidationService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Setter(onMethod_ = @Autowired)
public class BoardServiceImpl implements BoardService {

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
    public Long delete(Long id) {
        Board board = findByIdUnsafe(id);

        boardValidationService.validateDeleting();

        boardRepository.delete(board);
        return board.getId();
    }

    @Override
    public Board update(Long id, BoardUpdateDto dto) {
        Board board = findByIdUnsafe(id);

        boardValidationService.validateUpdating(board);

        return boardMapper.toEntity(dto, board);
    }

    @Override
    @Transactional(readOnly = true)
    public Board findByIdUnsafe(Long id) {
        return boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BoardOutcomeDto> getAll() {
        return boardRepository.findAll().stream()
                .map(boardMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existByRegistration(String registration) {
        return boardRepository.existsByRegistration(registration);
    }

//    @Override
//    public Board update(BoardUpdateRegistrationDto dto) {
//        boardValidationService.validateExistingBoardByRegistration(dto.getOldRegistration());
//        Board board = boardRepository.findByRegistration(dto.getOldRegistration());
//        boardValidationService.validateUpdatingRegistration(board, dto);
//        board.setRegistration(dto.getNewRegistration());
//
//        return board;
//    }

}
