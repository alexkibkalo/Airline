package com.fly.persistence.repository;

import com.fly.persistence.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findByRegistration(String registration);

}
