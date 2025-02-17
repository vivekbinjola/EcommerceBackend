package com.vivek.order.Service;

import com.vivek.order.DTO.OrderLineMapper;
import com.vivek.order.DTO.OrderLineRequest;
import com.vivek.order.DTO.OrderLineResponse;
import com.vivek.order.DTO.OrderResponse;
import com.vivek.order.Exceptions.OrderNotFoundException;
import com.vivek.order.Models.Order;
import com.vivek.order.Models.OrderLine;
import com.vivek.order.Repository.OrderLineRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<OrderLineResponse> getOrderById(int orderId) {

        List<OrderLine> res = repository.findOrderById(orderId);

        return res.stream()
                .map(mapper::fromOrderLine)
                .collect(Collectors.toList());
    }
    public List<OrderLineResponse> getOrderLines() {

        List<OrderLine> orderLines = repository.findAll();

        return orderLines.stream()
                .map(orderLine-> mapper.fromOrderLine(orderLine))
                .collect(Collectors.toList());

    }



}
