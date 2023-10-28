package com.courses.api.infrastructure.repository.section;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<SectionDto,Long> {

}
