package com.fly.persistence.entity.seat;

import com.fly.persistence.entity.general.IdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "seat")
public class Seat extends IdEntity {

    @Column(nullable = false)
    private Integer row;

    @Column(nullable = false)
    private String latter;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeSeat typeSeat;
}
