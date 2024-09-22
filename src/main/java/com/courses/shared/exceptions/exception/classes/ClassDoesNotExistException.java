package com.courses.shared.exceptions.exception.classes;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class ClassDoesNotExistException extends BaseException {

    public ClassDoesNotExistException(String message) {
        super(false, HttpStatus.NOT_FOUND, message, ExceptionCode.CLASS_NOT_FOUND);
    }
}
