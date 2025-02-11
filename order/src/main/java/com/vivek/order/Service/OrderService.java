package com.vivek.order.Service;

import com.vivek.order.Customer.CustomerClient;
import com.vivek.order.Customer.CustomerResponse;
import com.vivek.order.DTO.OrderLineRequest;
import com.vivek.order.DTO.OrderMapper;
import com.vivek.order.DTO.OrderRequest;
import com.vivek.order.Exceptions.CustomerNotFoundException;
import com.vivek.order.Models.Order;
import com.vivek.order.Models.OrderLine;
import com.vivek.order.Product.ProductClient;
import com.vivek.order.Product.PurchaseRequest;
import com.vivek.order.Product.PurchaseResponse;
import com.vivek.order.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;

    private final ProductRepository repository;
    private final OrderLineService OrderLineService;

    private final OrderMapper mapper;

    public Integer createOrder(OrderRequest req) {
//        check the customer
        CustomerResponse customerFromCustomerMS =
                customerClient.findCustomerById(req.customerId()).orElseThrow(()->
                     new CustomerNotFoundException("Customer with Id: "+ req.id()+ " not found."));

//        purchase the products -> product -ms
        List<PurchaseResponse> productPurchased =
                this.productClient.purchaseProducts(req.products());

//        persist order
        Order order = this.mapper.toOrder(req);

//        persist orderLines

        for(PurchaseRequest purchaseRequest :req.products()){
            this.OrderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    ));
        }

//        start payment process( after creating payment ms)

//        send order notification -> notification ms using kafka
        return null;
    }
}
