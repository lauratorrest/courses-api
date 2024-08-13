package com.courses.service.exception.classes;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class ClassWithNoVideoException extends BaseException {

  public ClassWithNoVideoException(String message) {
    super(false, HttpStatus.CONFLICT, message, ExceptionCode.CLASS_VIDEO_NEEDED);
  }
}
