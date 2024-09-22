package com.courses.shared.exceptions.exception.course;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class CourseWithUncompletedDataException extends BaseException {

    public CourseWithUncompletedDataException(String message) {
        super(false, HttpStatus.CONFLICT, message, ExceptionCode.UNCOMPLETED_DATA);
    }
}
