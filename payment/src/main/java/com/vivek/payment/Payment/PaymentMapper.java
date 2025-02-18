package com.vivek.payment.Payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

  public PaymentPOJO toPayment(PaymentRequest request) {
    if (request == null) {
      return null;
    }
    return PaymentPOJO.builder()
        .id(request.id())
        .paymentMethod(request.paymentMethod())
        .amount(request.amount())
        .orderId(request.orderId())
        .build();
  }
}