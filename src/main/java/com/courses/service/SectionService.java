package com.courses.service;

import com.courses.model.Class;
import com.courses.model.Section;
import java.util.List;

public interface SectionService {

  Section saveNewSection(Section section);

  void deleteSection(String sectionId, String courseId);

  List<Section> findSectionsByIds(List<String> ids);

  Class addNewClassToSection(Class entity, String sectionId);
}
