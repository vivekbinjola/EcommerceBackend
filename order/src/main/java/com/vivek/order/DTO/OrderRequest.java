package com.vivek.order.DTO;


import com.vivek.order.Models.PaymentMethod;
import com.vivek.order.Product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(

        Integer id,
        String reference,
        @Positive(message = "Amount should be greater than 0")
        BigDecimal amount,
        @NotNull(message = "Please specify the PaymentMethod")
        PaymentMethod paymentMethod,
        @NotNull(message = "customerId should not be null")
        @NotBlank(message = "customerId should not be blank")
        @NotEmpty(message = "customerId should not be empty")
        String customerId,
        @NotNull(message = "Please add atleast 1 product")
        List<PurchaseRequest> products

) {
}
