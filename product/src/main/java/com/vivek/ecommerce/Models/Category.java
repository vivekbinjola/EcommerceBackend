package com.vivek.ecommerce.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Category {


//   GenerationType.IDENTITY : Identity will autoincrement and assign new id to each entry inserted.
//    we have many types like sequence,table & auto,
//    auto : is used to choose automatically any one of them acc to the db.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
//  CascadeType.REMOVE:  when we remove a category, we'll remove all the products related to that category
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "category" )
    List<Product> products;
}

