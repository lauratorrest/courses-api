package com.courses.api.application.usercourse;

import com.courses.api.domain.entity.User;
import com.courses.api.domain.entity.UserCourse;
import com.courses.api.domain.service.usercourse.UserCourseSaveService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserCourseSaveApplication {
  private final UserCourseSaveService userCourseSaveService;

  public void saveUserCourse(UserCourse userCourse, User user){
    userCourse.setPurchaseDate(LocalDateTime.now());
    userCourse.setUser(user);
    userCourseSaveService.saveUserCourse(userCourse);
  }
}
