package com.courses.api.infrastructure.api.controller.user;

import com.courses.api.application.user.UserGetApplication;
import com.courses.api.application.user.UserSaveApplication;
import com.courses.api.infrastructure.api.dto.request.UserRequest;
import com.courses.api.infrastructure.api.mapper.user.UserRequestMapper;
import com.courses.api.infrastructure.api.mapper.user.UserResponseMapper;
import com.courses.api.infrastructure.api.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {
  private final UserGetApplication userGetApplication;
  private final UserSaveApplication userSaveApplication;
  private final UserRequestMapper userRequestMapper;
  private final UserResponseMapper userResponseMapper;

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id){
    return ResponseEntity.ok(userResponseMapper.toResponse(
        userGetApplication.getUserById(id)
    ));
  }

  @PostMapping
  public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest){
    return ResponseEntity.ok(userResponseMapper.toResponse(userSaveApplication.saveUser(
        userRequestMapper.toEntity(userRequest)
    )));
  }
}
