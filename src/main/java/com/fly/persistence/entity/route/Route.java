package com.fly.persistence.entity.route;

import com.fly.persistence.entity.filght.Flight;
import com.fly.persistence.entity.general.IdEntityCreatedUpdatedDeleted;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "route")
public class Route extends IdEntityCreatedUpdatedDeleted {

    @Column(nullable = false)
    private String fromCity;

    @Column(nullable = false)
    private String fromAirport;

    @Column(nullable = false)
    private String toCity;

    @Column(nullable = false)
    private String toAirport;

    @Column(nullable = false, unique = true, name = "from_airport_uid")
    private String fromAirportUID;

    @Column(nullable = false, unique = true, name = "to_airport_uid")
    private String toAirportUID;

    @Column(nullable = false)
    private Instant departureDate;

    @Column(nullable = false)
    private Instant returnDate;

    @OneToOne(mappedBy = "route")
    private Flight flight;
}
