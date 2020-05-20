package com.fly.service;

import com.fly.persistence.entity.user.User;
import com.fly.transport.dto.UserCreateDto;

public interface UserService {

    User create(UserCreateDto dto);
}
