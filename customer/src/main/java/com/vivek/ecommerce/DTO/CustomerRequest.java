package com.vivek.ecommerce.DTO;

import com.vivek.ecommerce.Models.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        @NotNull(message = "Id should not be null")
        String Id,
        @NotNull(message = "First Name should not be null")
        String firstName,
        @NotNull(message = "Last Name should not be null")
        String lastName,
        @NotNull(message = "Email should not be null")
        String email,
        @NotNull(message = "Address should not be null")
        Address address
) {
}
