package com.courses.service;

import com.courses.model.Section;

public interface SectionService {

  Section saveNewSection(Section section, String courseId);

  void deleteSection(String sectionId, String courseId);
}
