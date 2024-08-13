package com.courses.service.impl;

import com.courses.model.Class;
import com.courses.repository.classes.ClassMapper;
import com.courses.repository.classes.ClassRepository;
import com.courses.service.ClassService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClassServiceImpl implements ClassService {

  private final ClassRepository classRepository;

  @Override
  public Class saveClass(Class classModel) {
    classModel.setCreatedDate(LocalDateTime.now());
    classModel.setIsActive(Boolean.TRUE);
    return ClassMapper.INSTANCE.toEntity(
        classRepository.save(ClassMapper.INSTANCE.toDto(classModel)));
  }

  @Override
  public List<Class> findClassesDataBySectionListIds(List<String> ids) {
    return ClassMapper.INSTANCE.toEntity(classRepository.findAllById(ids));
  }
}
