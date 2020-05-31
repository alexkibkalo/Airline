package com.fly.persistence.repository;

import com.fly.persistence.entity.baggage.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaggageRepository extends JpaRepository<Baggage, Long> {
}
