package com.courses.api.infrastructure.adapter.sectionclass;

import com.courses.api.domain.entity.SectionClass;
import com.courses.api.domain.service.sectionclass.SectionClassGetService;
import com.courses.api.infrastructure.repository.sectionclass.SectionClassMapper;
import com.courses.api.infrastructure.repository.sectionclass.SectionClassRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SectionClassGetAdapter implements SectionClassGetService {
  private final SectionClassRepository sectionClassRepository;
  private final SectionClassMapper sectionClassMapper;

  @Override
  public List<SectionClass> getAllClassesBySectionId(Long sectionId) {
    return sectionClassMapper.toEntity(sectionClassRepository.getAllBySectionId(sectionId));
  }
}
