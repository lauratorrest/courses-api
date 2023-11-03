package com.courses.api.infrastructure.repository.usercourse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCourseRepository extends JpaRepository<UserCourseDto,Long> {

}
