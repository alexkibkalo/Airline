package com.fly.service.authorization;

import com.fly.exception.UserNotFoundException;
import com.fly.transport.dto.authorization.LoginDto;
import com.fly.transport.dto.token.TokenOutcomeDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AuthorizationService {

    TokenOutcomeDto login(LoginDto loginDto) throws UserNotFoundException;

}
