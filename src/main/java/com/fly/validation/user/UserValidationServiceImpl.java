package com.fly.validation.user;

import com.fly.exception.standart.InternalServerErrorException;
import com.fly.validation.ValidationType;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter(onMethod_ = @Autowired)
public class UserValidationServiceImpl implements UserValidationService {

    @Override
    public void validate(ValidationType validationType) {
        switch (validationType) {
            case PERMISSIONS_USER_SERVICE:
                validatePermissions();
                break;

            case CREATION_USER:
                validateCreation();
                break;

            default:
                throw new InternalServerErrorException("Incorrect validation type");
        }
    }

    private void validatePermissions() {
    }

    private void validateCreation() {
    }
}
