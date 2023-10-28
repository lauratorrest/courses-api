package com.courses.api.domain.service.user;

import com.courses.api.domain.entity.User;

public interface UserGetService {
  User getUserById(Long id);
}
