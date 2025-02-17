package com.vivek.order.DTO;

import com.vivek.order.Models.PaymentMethod;
import com.vivek.order.Product.PurchaseResponse;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderResponse(

        Integer id,
        String reference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        String customerId

) {
}
