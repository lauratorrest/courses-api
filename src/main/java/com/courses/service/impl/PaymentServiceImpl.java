package com.courses.service.impl;

import com.courses.model.PaymentCharge;
import com.courses.service.PaymentService;
import com.courses.shared.exceptions.ExceptionCode;
import com.courses.shared.exceptions.exception.payment.PaymentFailedException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final MessageSource messageSource;

    @Override
    public String makePaymentForCourse(PaymentCharge paymentCharge) {
        try {
            ChargeCreateParams createParams = new ChargeCreateParams.Builder()
                    .setAmount(Long.valueOf(paymentCharge.getAmount()))
                    .setCurrency("usd")
                    .setSource(paymentCharge.getToken())
                    .build();

            Charge charge = Charge.create(createParams);
            return "Payment successful: " + charge.getId();
        } catch (StripeException e) {
            throw new PaymentFailedException(
                    messageSource.getMessage(ExceptionCode.PAYMENT_FAILED.getType(), null, LocaleContextHolder.getLocale())
            );
        }
    }
}
