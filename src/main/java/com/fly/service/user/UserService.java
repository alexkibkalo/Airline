package com.fly.service.user;

import com.fly.persistence.entity.user.User;
import com.fly.transport.dto.user.UserCreateDto;
import com.fly.transport.dto.user.UserOutcomeDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(UserCreateDto dto);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    List<UserOutcomeDto> findAll();
}
