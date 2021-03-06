package com.fly.service.user;

import com.fly.exception.user.UserBadCredentialsException;
import com.fly.exception.user.UserNotFoundException;
import com.fly.persistence.entity.user.User;
import com.fly.persistence.repository.UserRepository;
import com.fly.service.password.Generator;
import com.fly.transport.dto.user.UserCreateDto;
import com.fly.transport.dto.user.UserOutcomeDto;
import com.fly.transport.dto.user.UserUpdateDto;
import com.fly.transport.dto.user.UserUpdateEmailDto;
import com.fly.transport.mapper.user.UserMapper;
import com.fly.validation.user.UserValidationService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
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
    private PasswordEncoder passwordEncoder;

    @Override
    public User create(UserCreateDto dto) {
        User user = userMapper.toEntity(dto);

        userValidationService.validateCreation(user);

        String password = Generator.generatePassword(9);
        System.out.println(password); //todo It will delete

        User actor = getActorFromContext();
        user.setCreatedAt(Instant.now());
        user.setCreatedBy(actor);
        user.setUpdatedAt(Instant.now());
        user.setUpdatedBy(actor);
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(password));

        //todo 38-42 must be generated automatically

        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(UserBadCredentialsException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByIdUnsafe(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        User user = findByIdUnsafe(id);

        userValidationService.validateDeleting(user);

        user.setDeleted(true);
    }

    @Override
    public Long recovery(Long id) {
        User user = findByIdUnsafe(id);

        userValidationService.validateRecovering(user);
        user.setDeleted(false);

        return user.getId();
    }

    @Override
    public Long update(Long id, UserUpdateDto dto) {
        User user = findByIdUnsafe(id);

        userValidationService.validateUpdating(user);

        return userMapper.toEntity(dto, user).getId();
    }

    @Override
    public Long update(UserUpdateEmailDto dto) {
        User user = findByIdUnsafe(getActorFromContext().getId());

        userValidationService.validateUpdatingEmail(user, dto);
        user.setEmail(dto.getNewEmail());

        return user.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserOutcomeDto> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}