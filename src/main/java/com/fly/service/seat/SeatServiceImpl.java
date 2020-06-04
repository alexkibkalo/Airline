package com.fly.service.seat;

import com.fly.exception.seat.SeatNotFoundException;
import com.fly.persistence.entity.seat.Seat;
import com.fly.persistence.repository.SeatRepository;
import com.fly.transport.dto.seat.SeatCreateDto;
import com.fly.transport.dto.seat.SeatOutcomeDto;
import com.fly.transport.dto.seat.SeatUpdateDto;
import com.fly.transport.mapper.seat.SeatMapper;
import com.fly.validation.seat.SeatValidationService;
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
public class SeatServiceImpl implements SeatService {

    private SeatRepository seatRepository;
    private SeatMapper seatMapper;
    private SeatValidationService seatValidationService;

    @Override
    public Seat create(SeatCreateDto dto) {
        Seat seat = seatMapper.toEntity(dto);

        seatValidationService.validateCreation(seat);

        return seatRepository.save(seat);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Seat> findById(Long id) {
        return seatRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Seat findByIdUnsafe(Long id) {
        return seatRepository.findById(id).orElseThrow(SeatNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        seatValidationService.validateDeleting();

        seatRepository.deleteById(id);
    }

    @Override
    public Long update(Long id, SeatUpdateDto dto) {
        Seat seat = findByIdUnsafe(id);

        seatValidationService.validateUpdating(dto);

        return seatMapper.toEntity(dto, seat).getId();
    }

    @Transactional
    @Override
    public List<SeatOutcomeDto> getAll() {
        return seatRepository.findAll().stream()
                .map(seatMapper::toDto)
                .collect(Collectors.toList());
    }
}
