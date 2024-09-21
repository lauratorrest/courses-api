package com.courses.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentCharge {

    private String token;
    private Integer amount;
}
