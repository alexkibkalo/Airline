package com.fly.validation.seat;

import com.fly.persistence.entity.seat.Seat;
import com.fly.service.seat.SeatService;
import com.fly.transport.dto.seat.SeatUpdateDto;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter(onMethod_ = @Autowired)
public class SeatValidationServiceImpl implements SeatValidationService {

    private SeatService seatService;

    @Override
    public void validateCreation(Seat seat) {

    }

    @Override
    public void validateDeleting() {

    }

    @Override
    public void validateUpdating(SeatUpdateDto seat) {

    }
}
