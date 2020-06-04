package com.fly.validation.route;

import com.fly.exception.standard.ForbiddenException;
import com.fly.persistence.entity.route.Route;
import com.fly.persistence.entity.user.User;
import com.fly.service.route.RouteService;
import com.fly.service.user.role.RoleUtils;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter(onMethod_ = @Autowired)
public class RouteValidationServiceImpl implements RouteValidationService{

    private RouteService routeService;

    @Override
    public void validateCreation(Route route) {
        validateCreationUpdatingDeletingRecoveryPermission();
    }

    @Override
    public void validateDeleting() {
        validateCreationUpdatingDeletingRecoveryPermission();
    }

    @Override
    public void validateUpdating(Route route) {
        validateCreationUpdatingDeletingRecoveryPermission();
    }

    @Override
    public void validateRecovery() {
        validateCreationUpdatingDeletingRecoveryPermission();
    }

    private void validateCreationUpdatingDeletingRecoveryPermission(){
        User actor = getActorFromContext();

        if(!RoleUtils.isAdmin(actor) && !RoleUtils.isManager(actor)){
            throw new ForbiddenException();
        }
    }
}
