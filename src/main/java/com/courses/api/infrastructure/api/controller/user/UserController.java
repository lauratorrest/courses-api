package com.courses.api.infrastructure.api.controller.user;

import com.courses.api.application.user.UserGetApplication;
import com.courses.api.infrastructure.api.UserResponseMapper;
import com.courses.api.infrastructure.api.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {
  private final UserGetApplication userGetApplication;
  private final UserResponseMapper userResponseMapper;

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getAllUsers(@PathVariable("id") Long id){
    return ResponseEntity.ok(userResponseMapper.toResponse(
        userGetApplication.getUserById(id)
    ));
  }
}
