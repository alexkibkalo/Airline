package com.fly.transport.mapper.user;

import com.fly.persistence.entity.user.User;
import com.fly.transport.dto.user.UserCreateDto;
import com.fly.transport.dto.user.UserOutcomeDto;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
@Setter(onMethod_ = @Autowired)
public abstract class UserMapper {

    public abstract User toEntity(UserCreateDto dto);

    public abstract UserOutcomeDto toDto(User user);
}

