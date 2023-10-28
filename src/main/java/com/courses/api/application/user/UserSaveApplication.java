package com.courses.api.application.user;

import com.courses.api.domain.entity.User;
import com.courses.api.domain.service.user.UserSaveService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserSaveApplication {
  private final UserSaveService userSaveService;

  public User saveUser(User user){
    user.setCreatedDate(LocalDateTime.now());
    return userSaveService.saveUser(user);
  }
}
