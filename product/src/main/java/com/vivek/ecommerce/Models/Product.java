package com.vivek.ecommerce.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
//    Since a product belongs to one category so Many(products) -> one(category) mapping
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
