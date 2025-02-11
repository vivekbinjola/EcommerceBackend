package com.vivek.order.DTO;

import com.vivek.order.Models.Order;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record OrderLineRequest(

        @NotNull(message = "order Id should not be null")
        Integer id,
        Integer order,
        Integer product_id,
        double quantity
) {
}
