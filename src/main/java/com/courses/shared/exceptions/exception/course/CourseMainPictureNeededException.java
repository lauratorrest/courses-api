package com.courses.shared.exceptions.exception.course;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class CourseMainPictureNeededException extends BaseException {

    public CourseMainPictureNeededException(String message) {
        super(false, HttpStatus.CONFLICT, message, ExceptionCode.MAIN_PIC_NEEDED);
    }
}
