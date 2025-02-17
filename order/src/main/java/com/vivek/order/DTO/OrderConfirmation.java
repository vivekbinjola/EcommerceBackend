package com.vivek.order.DTO;

import com.vivek.order.Customer.CustomerResponse;
import com.vivek.order.Models.PaymentMethod;
import com.vivek.order.Product.PurchaseResponse;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
