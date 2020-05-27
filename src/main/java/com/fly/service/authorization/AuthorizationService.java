package com.fly.service.authorization;

import com.fly.exception.UserNotFoundException;
import com.fly.transport.dto.authorization.LoginDto;
import com.fly.transport.dto.token.TokenOutcomeDto;

public interface AuthorizationService {

    TokenOutcomeDto login(LoginDto loginDto) throws UserNotFoundException;

}
