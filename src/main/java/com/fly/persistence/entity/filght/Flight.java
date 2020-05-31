package com.fly.persistence.entity.filght;

import com.fly.persistence.entity.board.Board;
import com.fly.persistence.entity.general.IdEntityCreatedUpdatedDeleted;
import com.fly.persistence.entity.passenger.Passenger;
import com.fly.persistence.entity.route.Route;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "flight")
public class Flight extends IdEntityCreatedUpdatedDeleted {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @Column(nullable = false)
    private Integer price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private FlightStatus status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "passengers_to_flights",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    private List<Passenger> passengers;
}
