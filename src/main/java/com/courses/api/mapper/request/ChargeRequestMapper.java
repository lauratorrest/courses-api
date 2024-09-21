package com.courses.api.mapper.request;

import com.courses.api.dto.request.ChargeRequest;
import com.courses.model.PaymentCharge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChargeRequestMapper {

    ChargeRequestMapper INSTANCE = Mappers.getMapper(ChargeRequestMapper.class);

    PaymentCharge toModel(ChargeRequest chargeRequest);
}
