package com.courses.api.mapper.response;

import com.courses.api.dto.response.UserLoginResponse;
import com.courses.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserResponseMapper {

    UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

    UserLoginResponse toResponse(User user);
}
