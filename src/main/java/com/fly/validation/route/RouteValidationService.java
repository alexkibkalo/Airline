package com.fly.validation.route;

import com.fly.persistence.entity.route.Route;
import com.fly.service.actor.ActorService;

public interface RouteValidationService extends ActorService {

    void validateCreation(Route route);

    void validateDeleting();

    void validateUpdating(Route route);

    void validateRecovery();
}
