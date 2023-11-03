package com.courses.api.application.usercourse.purchase;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.courses.api.domain.entity.ClientToken;
import com.courses.api.domain.entity.Purchase;

public interface PaymentService {
  BraintreeGateway getGateway();
  ClientToken getToken();
  Result<Transaction> checkout(Purchase purchase);
}