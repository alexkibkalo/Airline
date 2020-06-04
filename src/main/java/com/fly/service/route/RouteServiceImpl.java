package com.fly.service.route;

import com.fly.exception.route.RouteNotFoundException;
import com.fly.persistence.entity.route.Route;
import com.fly.persistence.entity.user.User;
import com.fly.persistence.repository.RouteRepository;
import com.fly.transport.dto.route.RouteCreateDto;
import com.fly.transport.dto.route.RouteOutcomeDto;
import com.fly.transport.dto.route.RouteUpdateDto;
import com.fly.transport.mapper.route.RouteMapper;
import com.fly.validation.route.RouteValidationService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Setter(onMethod_ = @Autowired)
public class RouteServiceImpl implements RouteService {

    private RouteRepository routeRepository;
    private RouteMapper routeMapper;
    private RouteValidationService routeValidationService;

    @Override
    public Route create(RouteCreateDto dto) {
        Route route = routeMapper.toEntity(dto);

        routeValidationService.validateCreation(route);

        User actor = getActorFromContext();
        route.setCreatedAt(Instant.now());
        route.setCreatedBy(actor);
        route.setUpdatedAt(Instant.now());
        route.setUpdatedBy(actor);

        return routeRepository.save(route);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Route> findById(Long id) {
        return routeRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Route findByIdUnsafe(Long id) {
        return routeRepository.findById(id).orElseThrow(RouteNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        Route route = findByIdUnsafe(id);

        routeValidationService.validateDeleting();

        route.setDeleted(true);
    }

    @Override
    public Long recovery(Long id) {
        Route route = findByIdUnsafe(id);

        routeValidationService.validateRecovery();
        route.setDeleted(false);

        return route.getId();
    }

    @Override
    public Long update(Long id, RouteUpdateDto dto) {
        Route route = findByIdUnsafe(id);

        routeValidationService.validateUpdating(route);

        return routeMapper.toEntity(dto, route).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<RouteOutcomeDto> getAll() {
        return routeRepository.findAll().stream()
                .map(routeMapper::toDto)
                .collect(Collectors.toList());
    }
}
