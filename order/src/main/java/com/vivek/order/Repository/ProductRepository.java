package com.vivek.order.Repository;

import com.vivek.order.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Order,Integer> {
}
