package com.courses.api.infrastructure.api.mapper.user;

import com.courses.api.domain.entity.User;
import com.courses.api.infrastructure.api.dto.request.UserRequest;
import org.mapstruct.Mapper;

@Mapper
public interface UserRequestMapper {
  User toEntity(UserRequest userRequest);
}
