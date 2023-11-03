package com.courses.api.infrastructure.repository.section;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<SectionDto,Long> {
  @Query("SELECT sd FROM SectionDto sd WHERE sd.courseId.id = :courseId")
  List<SectionDto> findAllByCourseId(Long courseId);
}
