package com.fly.persistence.entity.baggage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public class FlexBaggage extends StandardBaggage {

    private final boolean cancellation = true;

}
