package com.vivek.ecommerce.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
        @NotNull(message = "Id cannot be null")
        Integer id,

        @Positive(message = "Quantity should be positive")
        Double Quantity
) {
}
