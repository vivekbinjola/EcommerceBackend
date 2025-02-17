package com.vivek.order.Repository;

import com.vivek.order.Models.OrderLine;
import jakarta.ws.rs.QueryParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine,Integer> {

    @Query(value = "select * from OrderLines where order_id = :id", nativeQuery = true)
    public List<OrderLine> findOrderById(@Param("id") int orderId);
}
