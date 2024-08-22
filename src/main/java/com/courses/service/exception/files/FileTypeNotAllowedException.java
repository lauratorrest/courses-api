package com.courses.service.exception.files;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class FileTypeNotAllowedException extends BaseException {

    public FileTypeNotAllowedException(String message) {
        super(false, HttpStatus.BAD_REQUEST, message, ExceptionCode.FILE_TYPE_NOT_ALLOWED);
    }
}
