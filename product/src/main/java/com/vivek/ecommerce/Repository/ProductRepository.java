package com.vivek.ecommerce.Repository;

import com.vivek.ecommerce.DTO.ProductResponse;
import com.vivek.ecommerce.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByIdIn(List<Integer> Ids);
}
