package com.vivek.ecommerce.Controller;


import com.vivek.ecommerce.DTO.ProductPurchaseRequest;
import com.vivek.ecommerce.DTO.ProductPurchaseResponse;
import com.vivek.ecommerce.DTO.ProductRequest;
import com.vivek.ecommerce.DTO.ProductResponse;
import com.vivek.ecommerce.Models.Product;
import com.vivek.ecommerce.Service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private  final ProductService service;

    @GetMapping("/health")
    public String healthCheck(){
        return "check successful!";
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Integer> createProduct(
            @Valid @RequestBody  ProductRequest request
    ){
        return ResponseEntity.ok(service.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @Valid @RequestBody List<ProductPurchaseRequest> request
    ){
        return ResponseEntity.ok(service.purchaseProducts(request));
    }

    @GetMapping("/findByid/{productId}")
    public ResponseEntity<ProductResponse> findProductById(
        @PathVariable("productId") Integer productId
    ){
        return ResponseEntity.ok(service.findProductById(productId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductResponse>> findAllProducts(){
        System.out.print("vivek");
        System.out.print("vivek");
        return ResponseEntity.ok(service.findAllProducts());
    }
}
