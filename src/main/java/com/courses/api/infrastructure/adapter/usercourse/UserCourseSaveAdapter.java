package com.courses.api.infrastructure.adapter.usercourse;

import com.courses.api.domain.entity.UserCourse;
import com.courses.api.domain.service.usercourse.UserCourseSaveService;
import com.courses.api.infrastructure.repository.usercourse.UserCourseMapper;
import com.courses.api.infrastructure.repository.usercourse.UserCourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserCourseSaveAdapter implements UserCourseSaveService {
  private final UserCourseRepository userCourseRepository;
  private final UserCourseMapper userCourseMapper;

  @Override
  public void saveUserCourse(UserCourse userCourse) {
    userCourseRepository.save(userCourseMapper.toDto(userCourse));
  }
}
