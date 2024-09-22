package com.courses.shared.exceptions.exception.authentication;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class WrongPasswordException extends BaseException {

    public WrongPasswordException(String message) {
        super(false, HttpStatus.BAD_REQUEST, message, ExceptionCode.WRONG_PASSWORD);
    }
}
