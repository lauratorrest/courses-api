package com.courses.api.controller;

import com.courses.api.dto.UserCreateRequest;
import com.courses.api.mapper.UserCreateRequestMapper;
import com.courses.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "Users API", description = "End-points for users information management")
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @Operation(summary = "Create a new user")
  @ApiResponse(responseCode = "200", description = "User was successfully created")
  @PostMapping
  public void saveUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
    userService.saveNewUser(UserCreateRequestMapper.INSTANCE.toModel(userCreateRequest));
  }
}
