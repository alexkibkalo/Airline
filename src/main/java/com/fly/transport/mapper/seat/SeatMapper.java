package com.fly.transport.mapper.seat;

import com.fly.persistence.entity.seat.Seat;
import com.fly.transport.dto.seat.SeatCreateDto;
import com.fly.transport.dto.seat.SeatOutcomeDto;
import com.fly.transport.dto.seat.SeatUpdateDto;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
@Setter(onMethod_ = @Autowired)
public abstract class SeatMapper {


    public abstract Seat toEntity(SeatCreateDto dto);

    public abstract SeatOutcomeDto toDto(Seat seat);

    public abstract Seat toEntity(SeatUpdateDto dto, @MappingTarget Seat seat);
}
