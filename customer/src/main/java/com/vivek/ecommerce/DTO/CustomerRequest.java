package com.vivek.ecommerce.DTO;

import com.vivek.ecommerce.Models.Address;

public record CustomerRequest (


     String firstName,
     String lastName,
     String email,
      Address address
     ){}
