package com.vivek.notification.Kafka;

import com.vivek.notification.DTO.Customer;
import com.vivek.notification.DTO.PaymentMethod;
import com.vivek.notification.DTO.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public record OrderConfirmation(

        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
