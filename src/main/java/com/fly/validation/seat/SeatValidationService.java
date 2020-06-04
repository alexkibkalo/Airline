package com.fly.validation.seat;

import com.fly.persistence.entity.seat.Seat;
import com.fly.service.actor.ActorService;
import com.fly.transport.dto.seat.SeatUpdateDto;

public interface SeatValidationService extends ActorService {

    void validateCreation(Seat seat);

    void validateDeleting();

    void validateUpdating(SeatUpdateDto seat);

}
