package com.fly.persistence.repository;

import com.fly.persistence.entity.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
