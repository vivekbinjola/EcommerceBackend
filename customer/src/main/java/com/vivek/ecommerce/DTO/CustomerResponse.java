package com.vivek.ecommerce.DTO;

import com.vivek.ecommerce.Models.Address;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CustomerResponse {

    private String Id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;


}
