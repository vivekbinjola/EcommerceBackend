package com.vivek.order.Repository;

import com.vivek.order.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository< Order, Integer> {
}
