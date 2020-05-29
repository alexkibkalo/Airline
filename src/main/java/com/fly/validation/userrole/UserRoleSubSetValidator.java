package com.fly.validation.userrole;

import com.fly.persistence.entity.user.UserRole;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class UserRoleSubSetValidator implements ConstraintValidator<UserRoleSubset, UserRole> {

    private UserRole[] subset;

    @Override
    public void initialize(UserRoleSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(UserRole value, ConstraintValidatorContext context) {
        return value == null || subset == null || subset.length == 0 || Arrays.asList(subset).contains(value);
    }
}
