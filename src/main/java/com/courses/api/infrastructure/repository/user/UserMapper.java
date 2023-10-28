package com.courses.api.infrastructure.repository.user;

import com.courses.api.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User toEntity(UserDto userDto);
  UserDto toDto(User user);
}
