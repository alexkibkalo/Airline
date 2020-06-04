package com.fly.validation.typeseat;

import com.fly.persistence.entity.seat.TypeSeat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class TypeSeatSubSetValidator implements ConstraintValidator<TypeSeatSubset, TypeSeat> {

    private TypeSeat[] subset;

    @Override
    public void initialize(TypeSeatSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(TypeSeat value, ConstraintValidatorContext context) {
        return value == null || subset == null || subset.length == 0 || Arrays.asList(subset).contains(value);
    }
}
