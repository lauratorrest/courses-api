package com.courses.shared.exceptions.exception.payment;

import com.courses.shared.exceptions.BaseException;
import com.courses.shared.exceptions.ExceptionCode;
import org.springframework.http.HttpStatus;

public class PaymentFailedException extends BaseException {

    public PaymentFailedException(String message) {
        super(false, HttpStatus.CONFLICT, message, ExceptionCode.PAYMENT_FAILED);
    }
}
