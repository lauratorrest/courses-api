package com.courses.api.mapper.response;

import com.courses.api.dto.response.ClassBasicResponse;
import com.courses.model.Class;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassResponseMapper {

  ClassResponseMapper INSTANCE = Mappers.getMapper(ClassResponseMapper.class);

  ClassBasicResponse toResponse(Class aClass);
}
