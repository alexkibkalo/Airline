package com.fly.service.board;

import com.fly.exception.board.BoardNotFoundException;
import com.fly.persistence.entity.board.Board;
import com.fly.persistence.repository.BoardRepository;
import com.fly.transport.dto.board.BoardCreateDto;
import com.fly.transport.dto.board.BoardOutcomeDto;
import com.fly.transport.dto.board.BoardUpdateDto;
import com.fly.transport.mapper.board.BoardMapper;
import com.fly.validation.user.UserValidationService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Setter(onMethod_ = @Autowired)
public class BoardServiceImpl implements BoardService{

    private BoardRepository boardRepository;
    private BoardMapper boardMapper;
    private UserValidationService userValidationService;

    @Override
    public Board create(BoardCreateDto dto) {
        Board board = boardMapper.toEntity(dto);

        return boardRepository.save(board);
    }

    @Override
    public BoardOutcomeDto findByRegistration(String registration) {

        Board board = boardRepository.findByRegistration(registration).orElseThrow(BoardNotFoundException::new);

        return boardMapper.toDto(board);
    }

    @Override
    public BoardOutcomeDto findById(Long id) {

        Board board = boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);

        return boardMapper.toDto(board);
    }

    @Override
    public void delete(Long id) {
        boardRepository.deleteById(id);

    }

    @Override
    public Board update(Long id, BoardUpdateDto dto) {

        Board boardDb = boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);
        Board board = boardMapper.toEntity(dto);

        boardDb.setPhoto(board.getPhoto());
        boardDb.setIssue(board.getIssue());
        boardDb.setCountry(board.getCountry());
        boardDb.setCapacity(board.getCapacity());
        boardDb.setAirline(board.getAirline());
        boardDb.setAircraft(board.getAircraft());

        return boardRepository.save(boardDb);
    }
}
