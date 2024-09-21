package com.courses.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargeRequest {

    private String token;
    private Integer amount;
}
