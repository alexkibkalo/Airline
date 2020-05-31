package com.fly.persistence.entity.passenger;

import com.fly.persistence.entity.baggage.Baggage;
import com.fly.persistence.entity.filght.Flight;
import com.fly.persistence.entity.general.IdEntity;
import com.fly.persistence.entity.order.Order;
import com.fly.persistence.entity.seat.Seat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "passenger")
public class Passenger extends IdEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Instant dateOfBirthday;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private Gender gender;

    @Column(nullable = false)
    private String citizenship;

    @Column(nullable = false)
    private String passportNumber;

    @Column(nullable = false)
    private Instant passportExpiryDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "baggage_id")
    private Baggage baggage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToMany(mappedBy = "passengers")
    private List<Flight> flights;
}
