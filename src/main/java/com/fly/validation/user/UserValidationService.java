package com.fly.validation.user;

import com.fly.service.actor.ActorService;
import com.fly.validation.ValidationType;

public interface UserValidationService extends ActorService {

    void validate(ValidationType validationType);
}
