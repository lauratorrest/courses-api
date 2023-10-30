package com.courses.api.domain.service.sectionclass;

import com.courses.api.domain.entity.SectionClass;
import java.util.List;

public interface SectionClassGetService {
  List<SectionClass> getAllClassesBySectionId(Long sectionId);
}
