package com.courses.api.infrastructure.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseDto,Long> {

}
