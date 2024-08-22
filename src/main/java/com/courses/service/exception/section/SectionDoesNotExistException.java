package com.courses.service.exception.section;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class SectionDoesNotExistException extends BaseException {

    public SectionDoesNotExistException(String message) {
        super(false, HttpStatus.NOT_FOUND, message, ExceptionCode.SECTION_NOT_FOUND);
    }
}
