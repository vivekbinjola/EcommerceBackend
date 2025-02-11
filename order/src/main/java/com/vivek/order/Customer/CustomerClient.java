package com.vivek.order.Customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="customer-service",url = "${application.config.customer-url}")
public interface CustomerClient {

    @GetMapping("/health")
    public String checkConnectivityToCustomerService();

    @GetMapping("findById/{id}")
    public Optional<CustomerResponse> findCustomerById(@PathVariable("id") String id);
}
