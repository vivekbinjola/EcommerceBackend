package com.vivek.ecommerce.Service;

import com.vivek.ecommerce.DTO.ProductPurchaseRequest;
import com.vivek.ecommerce.DTO.ProductPurchaseResponse;
import com.vivek.ecommerce.DTO.ProductRequest;
import com.vivek.ecommerce.DTO.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
     Integer createProduct(@Valid ProductRequest request);

     List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);

     ProductResponse findProductById(Integer productId);

     List<ProductResponse> findAllProducts();
}
