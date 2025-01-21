package com.vivek.ecommerce.DTO;

import com.vivek.ecommerce.Models.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

public Customer toCustomer(CustomerRequest request){
    if(null == request){
        return null;
    }

    return Customer.builder()
            .id(request.Id())
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .address(request.address())
            .build();

}

public CustomerResponse toCustomerResponse(Customer customer){
    if(null == customer){
        return null;
    }

    CustomerResponse customerResponse = new CustomerResponse(
            customer.getId(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getEmail(),
            customer.getAddress()
    );
    return customerResponse;
}
}
