package com.courses.api.mapper.request;

import com.courses.api.dto.request.UserRequest;
import com.courses.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRequestMapper {

  UserRequestMapper INSTANCE = Mappers.getMapper(UserRequestMapper.class);

  User toModel(UserRequest userRequest);
}
