package com.fly.service.user;

import com.fly.persistence.entity.user.User;
import com.fly.transport.dto.user.UserCreateDto;
import com.fly.transport.dto.user.UserOutcomeDto;
import com.fly.transport.dto.user.UserUpdateDto;
import com.fly.transport.dto.user.UserUpdateEmailDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(UserCreateDto dto);

    Optional<User> findByEmail(String email);

    User findById(Long id);

    void delete(Long id);

    Long recovery(Long id);

    Long update(Long id, UserUpdateDto dto);

    Long update(Long id, UserUpdateEmailDto dto);

    List<UserOutcomeDto> getAll();
}
