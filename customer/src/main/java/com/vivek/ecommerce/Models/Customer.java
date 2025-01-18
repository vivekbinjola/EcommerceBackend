package com.vivek.ecommerce.Models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class Customer {

    @Id
    
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
}
