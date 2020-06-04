package com.fly.transport.mapper.route;

import com.fly.persistence.entity.route.Route;
import com.fly.transport.dto.route.RouteCreateDto;
import com.fly.transport.dto.route.RouteOutcomeDto;
import com.fly.transport.dto.route.RouteUpdateDto;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
@Setter(onMethod_ = @Autowired)
public abstract class RouteMapper {

    public abstract Route toEntity(RouteCreateDto dto);

    public abstract RouteOutcomeDto toDto(Route route);

    public abstract Route toEntity(RouteUpdateDto dto, @MappingTarget Route route);
}
