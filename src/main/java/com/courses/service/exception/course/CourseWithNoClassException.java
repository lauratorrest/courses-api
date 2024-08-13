package com.courses.service.exception.course;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class CourseWithNoClassException extends BaseException {

  public CourseWithNoClassException(String message) {
    super(false, HttpStatus.CONFLICT, message, ExceptionCode.NO_CLASSES_FOUND);
  }
}
