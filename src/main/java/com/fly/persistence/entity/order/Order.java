package com.fly.persistence.entity.order;

import com.fly.persistence.entity.filght.Flight;
import com.fly.persistence.entity.general.IdEntityCreatedUpdated;
import com.fly.persistence.entity.passenger.Passenger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "order")
public class Order extends IdEntityCreatedUpdated {

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Passenger> passengers;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id")
    private Flight flight;

}
