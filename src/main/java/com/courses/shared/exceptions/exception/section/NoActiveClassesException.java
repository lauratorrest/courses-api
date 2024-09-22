package com.courses.shared.exceptions.exception.section;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class NoActiveClassesException extends BaseException {

    public NoActiveClassesException(String message) {
        super(false, HttpStatus.CONFLICT, message, ExceptionCode.NO_ACTIVE_CLASSES);
    }
}
