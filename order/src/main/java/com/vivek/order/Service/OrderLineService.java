package com.vivek.order.Service;

import com.vivek.order.DTO.OrderLineMapper;
import com.vivek.order.DTO.OrderLineRequest;
import com.vivek.order.Models.OrderLine;
import com.vivek.order.Repository.OrderLineRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    public Integer saveOrderLine(OrderLineRequest req) {

        OrderLine orderLine = this.mapper.toOrderLine(req);
        this.repository.save(orderLine);
        return orderLine.getId();
    }
}
