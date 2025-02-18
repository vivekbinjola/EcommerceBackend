package com.vivek.order.Controller;

import com.vivek.order.DTO.OrderRequest;
import com.vivek.order.DTO.OrderResponse;
import com.vivek.order.Service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/createOrder")
    public ResponseEntity<Integer> createOrder(@Valid @RequestBody OrderRequest req){

        return ResponseEntity.ok(service.createOrder(req));
    }

    @GetMapping("/getOrders")
    public ResponseEntity<List<OrderResponse>> getAllOrders(){

        return ResponseEntity.ok(service.getAllOrders());
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@Valid @PathVariable("id") int id){

        return ResponseEntity.ok(service.getOrderById(id));
    }
}
