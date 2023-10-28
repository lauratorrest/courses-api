package com.courses.api.infrastructure.adapter.user;

import com.courses.api.domain.entity.User;
import com.courses.api.domain.service.user.UserSaveService;
import com.courses.api.infrastructure.repository.user.UserMapper;
import com.courses.api.infrastructure.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserSaveAdapter implements UserSaveService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public User saveUser(User user) {
    return userMapper.toEntity(userRepository.save(userMapper.toDto(user)));
  }
}
