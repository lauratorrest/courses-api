package com.courses.api.infrastructure.adapter.user;

import com.courses.api.domain.entity.User;
import com.courses.api.domain.service.user.UserGetService;
import com.courses.api.infrastructure.repository.user.UserDto;
import com.courses.api.infrastructure.repository.user.UserMapper;
import com.courses.api.infrastructure.repository.user.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserGetAdapter implements UserGetService {
  private final UserMapper userMapper;
  private final UserRepository userRepository;


  @Override
  public User getUserById(Long id) {
    Optional<UserDto> dto = userRepository.findById(id);
    return dto.map(userMapper::toEntity).orElseThrow(RuntimeException::new);
  }
}
