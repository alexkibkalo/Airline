package com.fly.service.seat;

import com.fly.persistence.entity.seat.Seat;
import com.fly.service.actor.ActorService;
import com.fly.transport.dto.seat.SeatCreateDto;
import com.fly.transport.dto.seat.SeatOutcomeDto;
import com.fly.transport.dto.seat.SeatUpdateDto;

import java.util.List;
import java.util.Optional;

public interface SeatService extends ActorService {

    Seat create(SeatCreateDto dto);

    Optional<Seat> findById(Long id);

    Seat findByIdUnsafe(Long id);

    void delete(Long id);

    Long update(Long id, SeatUpdateDto dto);

    List<SeatOutcomeDto> getAll();
}
