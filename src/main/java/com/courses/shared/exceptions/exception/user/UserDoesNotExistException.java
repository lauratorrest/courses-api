package com.courses.shared.exceptions.exception.user;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class UserDoesNotExistException extends BaseException {

    public UserDoesNotExistException(String message) {
        super(false, HttpStatus.NOT_FOUND, message, ExceptionCode.USER_NOT_FOUND);
    }
}
