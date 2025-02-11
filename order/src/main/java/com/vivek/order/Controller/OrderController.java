package com.vivek.order.Controller;

import com.vivek.order.DTO.OrderRequest;
import com.vivek.order.Service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService service;

    public ResponseEntity<Integer> createOrder(@Valid @RequestBody OrderRequest req){

        return ResponseEntity.ok(service.createOrder(req));
    }
}
