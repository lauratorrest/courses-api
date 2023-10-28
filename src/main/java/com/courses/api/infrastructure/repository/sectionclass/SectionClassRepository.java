package com.courses.api.infrastructure.repository.sectionclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionClassRepository extends JpaRepository<SectionClassDto,Long> {

}
