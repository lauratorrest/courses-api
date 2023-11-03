package com.courses.api.infrastructure.adapter.section;

import com.courses.api.domain.entity.Section;
import com.courses.api.domain.service.section.SectionGetService;
import com.courses.api.infrastructure.repository.section.SectionMapper;
import com.courses.api.infrastructure.repository.section.SectionRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SectionGetAdapter implements SectionGetService {

  private final SectionRepository sectionRepository;
  private final SectionMapper sectionMapper;

  @Override
  public List<Section> getAllByCourseId(Long courseId) {
    return sectionMapper.toEntity(sectionRepository.findAllByCourseId(courseId));
  }
}
