package com.fly.service.authorization;

import com.fly.configuration.security.properties.JWTProperties;
import com.fly.configuration.security.token.TokenHandler;
import com.fly.exception.user.UserInvalidPasswordException;
import com.fly.exception.user.UserNotFoundException;
import com.fly.persistence.entity.token.Token;
import com.fly.persistence.entity.user.User;
import com.fly.service.token.TokenService;
import com.fly.service.user.UserService;
import com.fly.transport.dto.authorization.LoginDto;
import com.fly.transport.dto.token.TokenOutcomeDto;
import com.fly.transport.mapper.token.TokenMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@Setter(onMethod_ = @Autowired)
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private TokenHandler tokenHandler;
    private TokenService tokenService;
    private TokenMapper tokenMapper;

    @Override
    public TokenOutcomeDto login(LoginDto loginDto) {
        User actor = userService.findByEmail(loginDto.getEmail());

        verification(actor);

        if (!passwordEncoder.matches(loginDto.getPassword(), actor.getPassword())) {
            throw new UserInvalidPasswordException();
        }

        Instant tokenExpiration = Instant.now()
                .plus(
                        JWTProperties.EXPIRATION_TIME,
                        ChronoUnit.HOURS
                );

        String tokenValue = tokenHandler.generateAccessToken(actor);
        Token token = actor.getToken();

        if (token != null) {
            token.setToken(tokenValue);
            token.setExpiration(tokenExpiration);
        } else {
            token = new Token(
                    tokenExpiration,
                    tokenValue,
                    actor
            );
        }
        tokenService.create(token);
        return tokenMapper.toDto(token);
    }

    @Override
    public void logout() {
        User actor = getActorFromContext();
        tokenService.delete(tokenService.findByUser(actor).orElse(null));
    }

    public void verification(User actor) throws UserNotFoundException {
        if (actor.getDeleted()) {
            throw new UserNotFoundException("User with email " + actor.getEmail() + " deleted");
        }
    }
}
