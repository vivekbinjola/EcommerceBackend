package com.vivek.order.Product;

import java.math.BigDecimal;

public record PurchaseResponse(

        String id,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
