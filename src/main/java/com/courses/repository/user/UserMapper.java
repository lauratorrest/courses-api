package com.courses.repository.user;

import com.courses.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserDto toDto(User user);

  User toEntity(UserDto userDto);
}
