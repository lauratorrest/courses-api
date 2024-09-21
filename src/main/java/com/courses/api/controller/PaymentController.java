package com.courses.api.controller;

import com.courses.api.dto.request.ChargeRequest;
import com.courses.api.mapper.request.ChargeRequestMapper;
import com.courses.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/charge")
    public ResponseEntity<String> chargeToCard(@RequestBody ChargeRequest chargeRequest) {
        return ResponseEntity.ok(paymentService.makePaymentForCourse(ChargeRequestMapper.INSTANCE.toModel(chargeRequest)));
    }
}
