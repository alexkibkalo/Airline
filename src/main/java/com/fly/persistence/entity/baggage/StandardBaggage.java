package com.fly.persistence.entity.baggage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public class StandardBaggage extends BasicBaggage {

    private final boolean changeDepartureDate = true;
    @Column(nullable = false)
    private Integer baggageWeight;

}
