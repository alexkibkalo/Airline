package com.fly.service.token;

import com.fly.persistence.entity.token.Token;
import com.fly.persistence.entity.user.User;

import java.util.Optional;

public interface TokenService {

    Token getByToken(String substring);

    Long create(Token token);

    Optional<Token> findByUser(User user);

    void delete(Token token);

    void extendExpiration(Token token);
}
