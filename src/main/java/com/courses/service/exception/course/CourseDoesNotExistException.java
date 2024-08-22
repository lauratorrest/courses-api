package com.courses.service.exception.course;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class CourseDoesNotExistException extends BaseException {

    public CourseDoesNotExistException(String message) {
        super(false, HttpStatus.NOT_FOUND, message, ExceptionCode.COURSE_NOT_FOUND);
    }
}
