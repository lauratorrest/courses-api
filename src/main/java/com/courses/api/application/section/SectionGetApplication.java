package com.courses.api.application.section;

import com.courses.api.domain.entity.SectionClass;
import com.courses.api.domain.service.sectionclass.SectionClassGetService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SectionGetApplication {
  private final SectionClassGetService sectionClassGetService;

  public int getSectionMinutesCount(Long sectionId){
    List<SectionClass> classes = sectionClassGetService.getAllClassesBySectionId(sectionId);

    int count = 0;

    for (SectionClass sectionClass : classes){
      count = count + sectionClass.getMinutesCount();
    }
    return count;
  }
}
