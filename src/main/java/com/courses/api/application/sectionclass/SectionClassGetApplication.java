package com.courses.api.application.sectionclass;

import com.courses.api.domain.entity.SectionClass;
import com.courses.api.domain.service.sectionclass.SectionClassGetService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SectionClassGetApplication {
  private final SectionClassGetService sectionClassGetService;

  public List<SectionClass> getAllBySectionId(Long sectionId){
    return sectionClassGetService.getAllClassesBySectionId(sectionId);
  }
}
