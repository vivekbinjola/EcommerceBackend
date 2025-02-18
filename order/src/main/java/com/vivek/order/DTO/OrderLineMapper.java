package com.vivek.order.DTO;

import com.vivek.order.Models.Order;
import com.vivek.order.Models.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.context.annotation.Configuration;

@Builder
@Configuration
@AllArgsConstructor
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest req){

        return new OrderLine(
                req.id(),
                Order.builder().id(req.order()).build(),
                req.product_id(),
                req.quantity()
        );
    }

    public OrderLineResponse fromOrderLine(OrderLine orderLine){

        return new OrderLineResponse(
                    orderLine.getId(),
                orderLine.getQuantity()
        );

    }
}
