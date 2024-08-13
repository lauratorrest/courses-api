package com.courses.api.mapper.request;

import com.courses.api.dto.request.ClassBasicRequest;
import com.courses.model.Class;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassRequestMapper {

  ClassRequestMapper INSTANCE = Mappers.getMapper(ClassRequestMapper.class);

  Class toEntity(ClassBasicRequest classBasicRequest);
}
