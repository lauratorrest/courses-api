package com.courses.api.infrastructure.api.mapper.user;

import com.courses.api.domain.entity.User;
import com.courses.api.infrastructure.api.dto.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
  UserResponse toResponse(User user);
}
