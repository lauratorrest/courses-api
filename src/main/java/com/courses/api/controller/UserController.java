package com.courses.api.controller;

import com.courses.api.dto.request.UserCreateRequest;
import com.courses.api.dto.response.UserLoginResponse;
import com.courses.api.mapper.request.UserRequestMapper;
import com.courses.api.mapper.response.UserResponseMapper;
import com.courses.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "Users API", description = "End-points for users information management")
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @Operation(summary = "Create a new user")
  @PostMapping("/register")
  public void saveUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
    userService.saveNewUser(UserRequestMapper.INSTANCE.toModel(userCreateRequest));
  }

  @Operation(summary = "Login with user credentials")
  @PostMapping(value = "/login")
  public ResponseEntity<UserLoginResponse> userLogin(@RequestParam("email") String email, @RequestParam("password") String password){
    return ResponseEntity.ok(UserResponseMapper.INSTANCE.toResponse(userService.authenticateUser(email, password)));
  }
}
