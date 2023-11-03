package com.courses.api.application.usercourse.purchase;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.ClientTokenRequest;
import com.braintreegateway.Environment;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import com.courses.api.config.BraintreeConfig;
import com.courses.api.domain.entity.ClientToken;
import com.courses.api.domain.entity.Purchase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService{
  @Autowired
  BraintreeConfig config;

  @Override
  public BraintreeGateway getGateway() {
    return new BraintreeGateway(
        Environment.SANDBOX,
        config.getMerchantId(),
        config.getPublicKey(),
        config.getPrivateKey()
    );
  }

  @Override
  public ClientToken getToken() {
    ClientTokenRequest clientTokenRequest = new ClientTokenRequest();
    String token = getGateway().clientToken().generate(clientTokenRequest);
    return new ClientToken(token);
  }

  @Override
  public Result<Transaction> checkout(Purchase purchase) {
    TransactionRequest request = new TransactionRequest()
        .amount(purchase.getAmount())
        .paymentMethodNonce(purchase.getNonce())
        .options()
        .submitForSettlement(true)
        .done();
    return getGateway().transaction().sale(request);
  }
}
