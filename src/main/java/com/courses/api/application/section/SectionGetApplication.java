package com.courses.api.application.section;

import com.courses.api.domain.entity.Section;
import com.courses.api.domain.service.section.SectionGetService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SectionGetApplication {
  private final SectionGetService sectionGetService;

  public List<Section> getAllSectionsByCourseId(Long courseId){
    return sectionGetService.getAllByCourseId(courseId);
  }
}
