package com.vivek.order.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "OrderLines")
public class OrderLine {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull(message = "order Id should not be null")
    @ManyToOne
//    even if we don't do @Join column, column will be joined by the primary key with the same name
//    order_id
    @JoinColumn(name="order_id")
    private Order order;
    private Integer product_id;
    private double quantity;
}
