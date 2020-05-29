package com.fly.service.user;

import com.fly.exception.user.UserInvalidEmailException;
import com.fly.persistence.entity.user.User;
import com.fly.persistence.repository.UserRepository;
import com.fly.transport.dto.user.UserCreateDto;
import com.fly.transport.dto.user.UserOutcomeDto;
import com.fly.transport.dto.user.UserUpdateDto;
import com.fly.transport.dto.user.UserUpdateEmailDto;
import com.fly.transport.mapper.user.UserMapper;
import com.fly.validation.ValidationType;
import com.fly.validation.user.UserValidationService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Setter(onMethod_ = @Autowired)
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private UserValidationService userValidationService;

    @Override
    public User create(UserCreateDto dto) {
        User user = userMapper.toEntity(dto);

        validateCreation();

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(UserInvalidEmailException::new);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Long recovery(Long id) {
        return null;
    }

    @Override
    public Long update(Long id, UserUpdateDto dto) {
        return null;
    }

    @Override
    public Long update(Long id, UserUpdateEmailDto dto) {
        return null;
    }

    @Override
    public List<UserOutcomeDto> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    private void validateCreation() {
        userValidationService.validate(ValidationType.PERMISSIONS_USER_SERVICE);
        userValidationService.validate(ValidationType.CREATION_USER);
    }
}