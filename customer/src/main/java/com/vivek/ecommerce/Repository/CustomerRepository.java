package com.vivek.ecommerce.Repository;

import com.vivek.ecommerce.Models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {

}
