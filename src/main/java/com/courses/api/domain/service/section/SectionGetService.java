package com.courses.api.domain.service.section;

import com.courses.api.domain.entity.Section;
import java.util.List;

public interface SectionGetService {
  List<Section> getAllByCourseId(Long courseId);
}
