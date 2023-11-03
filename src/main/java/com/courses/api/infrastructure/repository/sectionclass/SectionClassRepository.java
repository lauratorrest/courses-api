package com.courses.api.infrastructure.repository.sectionclass;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SectionClassRepository extends JpaRepository<SectionClassDto,Long> {
  @Query("SELECT scd FROM SectionClassDto scd WHERE scd.sectionId.id = :sectionId")
  List<SectionClassDto> getAllBySectionId(Long sectionId);
}
