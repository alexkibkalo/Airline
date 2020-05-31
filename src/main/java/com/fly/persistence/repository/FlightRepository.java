package com.fly.persistence.repository;

import com.fly.persistence.entity.filght.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
