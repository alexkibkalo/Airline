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
public class BasicBaggage extends Baggage {

    @Column(nullable = false)
    private boolean isHandLuggage = true;

    @Column(nullable = false)
    private Integer handLuggageWeight;

}
