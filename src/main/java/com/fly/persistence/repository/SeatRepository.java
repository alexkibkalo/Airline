package com.fly.persistence.repository;

import com.fly.persistence.entity.seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
