package com.vivek.order.DTO;

import com.vivek.order.Models.Order;
import com.vivek.order.Models.OrderLine;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderMapper {

    public Order toOrder(OrderRequest req){
        Order order = Order.builder()
                .reference(req.reference())
                .paymentMethod(req.paymentMethod())
                .totalAmount(req.amount())
                .customerId(req.customerId())
                .build();

        return order;
    }
}
