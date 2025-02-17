package com.vivek.order.DTO;

import com.vivek.order.Models.Order;
import com.vivek.order.Models.OrderLine;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public record OrderLineResponse(

        Integer id,
        double quantity
) {
}
