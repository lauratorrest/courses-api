package com.courses.api.application.user;

import com.courses.api.domain.entity.User;
import com.courses.api.domain.service.user.UserGetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserGetApplication {
  private final UserGetService userGetService;

  public User getUserById(Long id){
    return userGetService.getUserById(id);
  }
}
