package com.courses.api.infrastructure.adapter.sectionclass;

import com.courses.api.domain.entity.SectionClass;
import com.courses.api.domain.service.sectionclass.SectionClassSaveService;
import com.courses.api.infrastructure.repository.sectionclass.SectionClassMapper;
import com.courses.api.infrastructure.repository.sectionclass.SectionClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SectionClassSaveAdapter implements SectionClassSaveService {

  private final SectionClassRepository sectionClassRepository;
  private final SectionClassMapper sectionClassMapper;

  @Override
  public void saveClass(SectionClass sectionClass) {
    sectionClassRepository.save(sectionClassMapper.toDto(sectionClass));
  }
}
