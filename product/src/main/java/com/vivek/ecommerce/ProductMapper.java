package com.vivek.ecommerce;

import com.vivek.ecommerce.DTO.ProductPurchaseResponse;
import com.vivek.ecommerce.DTO.ProductRequest;
import com.vivek.ecommerce.DTO.ProductResponse;
import com.vivek.ecommerce.Models.Category;
import com.vivek.ecommerce.Models.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product convertToProduct(ProductRequest request) {
        if (null == request) {
            return null;
        }
        return Product
                .builder()
//                .id(request.id())
                .name(request.name())
                .category(Category.builder().id(request.categoryId()).build())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .build();
    }

    public ProductResponse convertToProductResponse(Product product) {
        ProductResponse response = new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()

        );

        return response;

    }

    public ProductPurchaseResponse convertToProductPurchaseResponse(Product product, double quantity){

        ProductPurchaseResponse response = new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
        return response;
    }

}
