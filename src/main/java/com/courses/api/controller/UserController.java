package com.courses.api.controller;

import com.courses.api.dto.request.UserRequest;
import com.courses.api.dto.response.UserLoginResponse;
import com.courses.api.mapper.request.UserRequestMapper;
import com.courses.api.mapper.response.UserResponseMapper;
import com.courses.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Tag(name = "Users API", description = "End-points for users information management")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Create a new user")
    @PostMapping("/register")
    public void saveUser(@Valid @RequestBody UserRequest userRequest) {
        userService.saveNewUser(UserRequestMapper.INSTANCE.toModel(userRequest));
    }

    @Operation(summary = "Login with user credentials")
    @PostMapping(value = "/login")
    public ResponseEntity<UserLoginResponse> userLogin(@RequestParam("email") String email,
                                                       @RequestParam("password") String password) {
        return ResponseEntity.ok(
                UserResponseMapper.INSTANCE.toResponse(userService.authenticateUser(email, password)));
    }

    @Operation(summary = "Update existing user information")
    @PutMapping("/update-info")
    public void updateUserData(@RequestBody @Valid UserRequest userRequest) {
        userService.updateUserData(UserRequestMapper.INSTANCE.toModel(userRequest));
    }

    @Operation(summary = "Set user profile picture")
    @PostMapping(value = "/profile-pic", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void setProfilePicture(@RequestBody(required = false) MultipartFile picture,
                                  @RequestParam("userId") String userId) {
        userService.setUserProfilePicture(picture, userId);
    }

    @Operation(summary = "Manage current user cart course")
    @PostMapping("/{userId}/cart-course/{courseId}")
    public void courseToCart(@PathVariable("userId") String userId, @PathVariable("courseId") String courseId) {
        userService.courseToCart(userId, courseId);
    }
}
