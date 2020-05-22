package com.fly.service;

import com.fly.persistence.entity.user.User;
import com.fly.persistence.repository.UserRepository;
import com.fly.transport.dto.UserCreateDto;
import com.fly.transport.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User create(UserCreateDto dto) {
        User user = userMapper.toEntity(dto);

        validateCreation(user);

        return userRepository.save(user);
    }

    private void validateCreation(User user) {
        validatePermission(user);
    }

    private void validatePermission(User user) {

    }
}
