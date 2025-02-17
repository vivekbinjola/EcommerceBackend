package com.vivek.order.Controller;

import com.vivek.order.DTO.OrderLineRequest;
import com.vivek.order.DTO.OrderLineResponse;
import com.vivek.order.DTO.OrderRequest;
import com.vivek.order.DTO.OrderResponse;
import com.vivek.order.Models.OrderLine;
import com.vivek.order.Service.OrderLineService;
import com.vivek.order.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orderLines")
public class OrderLineController {

    private final OrderLineService service;

    @GetMapping("/getOrderLines")
    public ResponseEntity<List<OrderLineResponse>> getOrderLines(){

        return ResponseEntity.ok(service.getOrderLines());
    }

    @GetMapping("/findOrderById/{order-id}")
    public ResponseEntity<List<OrderLineResponse>> findOrderById(@Valid @PathVariable("order-id") int orderId){

        return ResponseEntity.ok(service.getOrderById(orderId));
    }
}
