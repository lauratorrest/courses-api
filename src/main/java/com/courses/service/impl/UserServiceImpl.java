package com.courses.service.impl;

import com.courses.model.User;
import com.courses.repository.UserRepository;
import com.courses.service.UserService;
import com.courses.shared.utils.StringFixProcesses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final StringFixProcesses stringFixProcesses;

  @Override
  public void saveNewUser(User user) {
    user.setName(stringFixProcesses.removeSpaces(user.getName()));
    user.setProfession(stringFixProcesses.removeSpaces(user.getProfession()));
    user.onCreate();
    userRepository.save(user);
  }
}
