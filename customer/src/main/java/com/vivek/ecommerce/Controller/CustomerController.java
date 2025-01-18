package com.vivek.ecommerce.Controller;

import com.vivek.ecommerce.DTO.CustomerRequest;
import com.vivek.ecommerce.Models.Customer;
import com.vivek.ecommerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    public  CustomerService customerService;

    public ResponseEntity<String> createCustomer(
            @RequestBody CustomerRequest request
            ){
        String responseMessage = customerService.createCustomer(request);
        return new ResponseEntity<> (responseMessage,HttpStatus.CREATED);
    }

}
