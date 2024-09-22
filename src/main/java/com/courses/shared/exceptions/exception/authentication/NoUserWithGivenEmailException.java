package com.courses.shared.exceptions.exception.authentication;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class NoUserWithGivenEmailException extends BaseException {

    public NoUserWithGivenEmailException(String message) {
        super(false, HttpStatus.NOT_FOUND, message, ExceptionCode.USER_WITH_EMAIL_NOT_FOUND);
    }
}
