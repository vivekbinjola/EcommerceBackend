package com.vivek.order.Product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest (

        @NotNull(message = "Please specify a product Id")
        Integer productId,
        @Positive(message = "quantity should be more than 0")
        double quantity
) {
//    records can have static fields but not instance members
//    private static int id;
// records can have methods
//    public Integer test(){
//        System.out.println("vivek");
//        return null;
//    }
}
