package com.vivek.ecommerce.DTO;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(

        Integer id,
        @NotNull(message = "Name must not be null")
        String name,
        @NotNull(message = "Description must not be null")
        String description,
        @Positive(message = "Available Quantity should be positive")
        double availableQuantity,
        @Positive(message = "Price should be positive")
        BigDecimal price,
        @NotNull(message = "Product categoryId is required")
        Integer categoryId
) {
}
