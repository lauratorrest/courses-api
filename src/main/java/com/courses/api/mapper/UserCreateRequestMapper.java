package com.courses.api.mapper;

import com.courses.api.dto.UserCreateRequest;
import com.courses.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserCreateRequestMapper {

  UserCreateRequestMapper INSTANCE = Mappers.getMapper(UserCreateRequestMapper.class);

  User toModel(UserCreateRequest userCreateRequest);
}
