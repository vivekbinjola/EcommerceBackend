package com.vivek.order.Payment;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "payment-service", url="${application.config.payment-url}")
public interface PaymentClient {

    @PostMapping
    public Integer createPayment(@RequestBody  PaymentRequest request);
}
