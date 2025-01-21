package com.vivek.ecommerce.Service;

import com.vivek.ecommerce.DTO.CustomerMapper;
import com.vivek.ecommerce.DTO.CustomerRequest;
import com.vivek.ecommerce.DTO.CustomerResponse;
import com.vivek.ecommerce.Exceptions.CustomerNotFoundException;
import com.vivek.ecommerce.Models.Customer;
import com.vivek.ecommerce.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {

    @Autowired
    private  CustomerRepository repository;
    @Autowired
    private CustomerMapper mapper;

    @Autowired
    private ModelMapper modelMapper;

    public String createCustomer(CustomerRequest request) {

        Customer customer = mapper.toCustomer(request);
//        modelMapper.map(request, Customer.class);
        repository.save(customer);
        System.out.println(customer);
        return "Customer Saved";
    }


    public void updateCustomer(CustomerRequest request) {

        String customerId = request.Id();
        Customer customer = repository.findById(customerId).orElseThrow(()->
         new CustomerNotFoundException(
                 "Customer with : " + request.Id() + " Not Present in the Repository")

        );
        Customer newCustomer = mapper.toCustomer(request);
//            Customer newCustomer = modelMapper.map(request,Customer.class);
            repository.save(newCustomer);

    }

    public List<CustomerResponse> getAllCustomers() {

        List<CustomerResponse> ll = repository.findAll()
                .stream()
                .map(c-> mapper.toCustomerResponse(c))
                .collect(Collectors.toList());

        return ll;
    }

    public CustomerResponse findCustomerById(String id) {

        return repository.findById(id).map(mapper::toCustomerResponse)
        .orElseThrow(()->
                new CustomerNotFoundException("Customer with : " + id+ " Not Present in the Repository")
        );
//        return modelMapper.map(customer,CustomerResponse.class);
    }

    public String deleteCustomerById(String id) {
        Customer customer = repository.findById(id).orElseThrow(()->
                new CustomerNotFoundException("Customer with : " + id+ " Not Present in the Repository")
        );
        repository.deleteById(customer.getId());
        return "Deletion Successful";
    }
}
