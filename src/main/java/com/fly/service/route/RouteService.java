package com.fly.service.route;

import com.fly.persistence.entity.route.Route;
import com.fly.service.actor.ActorService;
import com.fly.transport.dto.route.RouteCreateDto;
import com.fly.transport.dto.route.RouteOutcomeDto;
import com.fly.transport.dto.route.RouteUpdateDto;

import java.util.List;
import java.util.Optional;

public interface RouteService extends ActorService {

    Route create(RouteCreateDto dto);

    Optional<Route> findById(Long id);

    Route findByIdUnsafe(Long id);

    void delete(Long id);

    Long recovery(Long id);

    Long update(Long id, RouteUpdateDto dto);

    List<RouteOutcomeDto> getAll();
}
