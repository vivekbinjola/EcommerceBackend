package com.vivek.order.Product;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarReactiveAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="product-service", url = "${application.config.product-url}")
public interface ProductClient {

    @GetMapping("/purchase")
    List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> req);
}
