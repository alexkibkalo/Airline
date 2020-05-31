package com.fly.validation.user;

import com.fly.persistence.entity.user.User;
import com.fly.service.actor.ActorService;
import com.fly.transport.dto.user.UserUpdateEmailDto;

public interface UserValidationService extends ActorService {

    void validateCreation(User user);

    void validateDeleting(User user);

    void validateUpdating(User user);

    void validateUpdatingEmail(User user, UserUpdateEmailDto dto);

    void validateRecovering(User user);
}
