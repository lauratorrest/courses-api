package com.courses.shared.exceptions.exception.files;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class TooBigFileException extends BaseException {

    public TooBigFileException(String message) {
        super(false, HttpStatus.BAD_REQUEST, message, ExceptionCode.FILE_EXCEEDS_ALLOWED_SIZE);
    }
}