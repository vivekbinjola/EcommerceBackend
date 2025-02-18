package com.vivek.order.Payment;


import com.vivek.order.Customer.CustomerResponse;
import com.vivek.order.Models.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(

        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
