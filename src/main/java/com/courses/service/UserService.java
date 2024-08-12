package com.courses.service;

import com.courses.model.User;

public interface UserService {

  void saveNewUser(User model);

  User authenticateUser(String email, String password);

  void updateUserData(User model);
}
