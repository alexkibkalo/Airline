package com.fly.transport.mapper.user;

import com.fly.persistence.entity.user.User;
import com.fly.transport.dto.user.UserCreateDto;
import com.fly.transport.dto.user.UserOutcomeDto;
import com.fly.transport.dto.user.UserUpdateDto;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

@Mapper(imports = Collections.class)
@Setter(onMethod_ = @Autowired)
public abstract class UserMapper {

    @Mapping(target = "authorities", expression = "java(Collections.singletonList(dto.getUserRole()))")
    public abstract User toEntity(UserCreateDto dto);

    @Mapping(target = "createdById", expression = "java(user.getCreatedBy().getId())")
    @Mapping(target = "updatedById", expression = "java(user.getUpdatedBy().getId())")
    public abstract UserOutcomeDto toDto(User user);

    public abstract User toEntity(UserUpdateDto dto, @MappingTarget User user);
}

