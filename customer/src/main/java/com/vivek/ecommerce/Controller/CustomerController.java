package com.vivek.ecommerce.Controller;

import com.vivek.ecommerce.DTO.CustomerRequest;
import com.vivek.ecommerce.DTO.CustomerResponse;
import com.vivek.ecommerce.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    public CustomerService service;

    @GetMapping("/health")
    public String health(){
        return "Health ok";
    }
    @PostMapping("/addCustomer")
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
            ){
        String responseMessage = service.createCustomer(request);
        System.out.println(responseMessage);
        return new ResponseEntity<> (responseMessage,HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<String> updateCustomer(
            @Valid  @RequestBody CustomerRequest request
    ){
        service.updateCustomer(request);
        return new ResponseEntity<> ("Customer Updated",HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponse>> getALlCustomers(){

        List<CustomerResponse> customersList = service.getAllCustomers();
        return new ResponseEntity<> ( customersList, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<CustomerResponse> findCustomerById(
            @PathVariable @Valid String id
    ){
        CustomerResponse customer = service.findCustomerById(id);

        return new ResponseEntity<> (customer ,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomerById( @PathVariable String id){
        String msg = service.deleteCustomerById(id);
        return new ResponseEntity<> (msg, HttpStatus.OK);
    }
}
