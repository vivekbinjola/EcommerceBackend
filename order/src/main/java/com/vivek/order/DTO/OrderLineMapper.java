package com.vivek.order.DTO;

import com.vivek.order.Models.Order;
import com.vivek.order.Models.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest req){
       return OrderLine.builder()
               .id(req.id())
               .order(Order.builder()
                       .id(req.order())
                       .build())
                .product_id(req.product_id())
                .quantity(req.quantity())
                .build();
    }
}
