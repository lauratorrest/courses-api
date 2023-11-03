package com.courses.api.infrastructure.api.controller;

import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.courses.api.application.usercourse.UserCourseSaveApplication;
import com.courses.api.domain.entity.ClientToken;
import com.courses.api.domain.entity.Purchase;
import com.courses.api.domain.entity.User;
import com.courses.api.infrastructure.api.dto.request.UserCourseRequest;
import com.courses.api.infrastructure.api.mapper.usercourse.UserCourseRquestMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user-course")
public class UserCourseController {
  private final UserCourseSaveApplication userCourseSaveApplication;
  private final UserCourseRquestMapper userCourseRquestMapper;

  @PostMapping
  public ResponseEntity<String> saveUserCourse(@RequestHeader("USER_ID") Long userId,
      @RequestBody UserCourseRequest userCourseRequest){
    User user = new User();
    user.setId(userId);

    userCourseSaveApplication.saveUserCourse(userCourseRquestMapper.toEntity(userCourseRequest), user);

    return ResponseEntity.ok("¡Compra exitosa!");
  }

  @GetMapping("/token")
  public ResponseEntity<ClientToken> getToken(){
    return ResponseEntity.ok(userCourseSaveApplication.getToken());
  }

  @PostMapping("/checkout")
  public ResponseEntity<Result<Transaction>> checkout(@RequestBody Purchase dto){
    return ResponseEntity.ok(userCourseSaveApplication.checkout(dto));
  }
}
