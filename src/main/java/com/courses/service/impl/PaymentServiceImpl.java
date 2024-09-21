package com.courses.service.impl;

import com.courses.model.PaymentCharge;
import com.courses.service.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

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
            return "Payment failed: " + e;
        }
    }
}
