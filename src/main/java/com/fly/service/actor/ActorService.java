package com.fly.service.actor;

import com.fly.exception.user.UserNotFoundException;
import com.fly.persistence.entity.user.User;
import com.fly.service.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public interface ActorService {

    default User getActorFromContext() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))) {
            return null;
        }

        return ApplicationContextProvider.getApplicationContext()
                .getBean(UserService.class)
                .findById(((User) authentication.getPrincipal()).getId())
                .orElseThrow(UserNotFoundException::new);
    }
}