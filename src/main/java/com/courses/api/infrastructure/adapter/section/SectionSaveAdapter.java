package com.courses.api.infrastructure.adapter.section;

import com.courses.api.domain.entity.Section;
import com.courses.api.domain.service.section.SectionSaveService;
import com.courses.api.infrastructure.repository.section.SectionMapper;
import com.courses.api.infrastructure.repository.section.SectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SectionSaveAdapter implements SectionSaveService {

  private final SectionRepository sectionRepository;
  private final SectionMapper sectionMapper;

  @Override
  public Section saveSection(Section section) {
   return sectionMapper.toEntity(sectionRepository.save(sectionMapper.toDto(section)));
  }
}
