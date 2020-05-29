package com.fly.service.authorization;

import com.fly.service.actor.ActorService;
import com.fly.transport.dto.authorization.LoginDto;
import com.fly.transport.dto.token.TokenOutcomeDto;

public interface AuthorizationService extends ActorService {

    TokenOutcomeDto login(LoginDto loginDto);

    void logout();

}
