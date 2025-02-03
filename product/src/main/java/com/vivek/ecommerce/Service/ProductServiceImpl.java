package com.vivek.ecommerce.Service;

import com.vivek.ecommerce.DTO.ProductPurchaseRequest;
import com.vivek.ecommerce.DTO.ProductPurchaseResponse;
import com.vivek.ecommerce.DTO.ProductRequest;
import com.vivek.ecommerce.DTO.ProductResponse;
import com.vivek.ecommerce.Exception.ProductPurchaseException;
import com.vivek.ecommerce.Models.Product;
import com.vivek.ecommerce.ProductMapper;
import com.vivek.ecommerce.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductMapper mapper;
    @Autowired
    private final ProductRepository repository;

//    @Autowired
//    public ProductServiceImpl(ProductMapper mapper, ProductRepository repository){
//        this.mapper = mapper;
//        this.repository = repository;
//    }

    @Override
    public Integer createProduct(ProductRequest request) {

        Product product = mapper.convertToProduct(request);
        repository.save(product);

        return product.getId();
    }

    @Override
    @Transactional(rollbackFor = ProductPurchaseException.class)
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {

//        Fetch all the Ids from the request
        List<Integer> productIds = request.stream()
                .map(ProductPurchaseRequest::id).collect(Collectors.toList());

        // Fetch all the matching products from DB with request products in one query
//        if found in DB, will be mapped to productMap otherwise will not be present.
        Map<Integer, Product> productMap = repository.findByIdIn(productIds)
        .stream().collect(Collectors.toMap(Product::getId, p -> p));

//        After that, check if the requested products exists int the DB by checking if
//        the Ids are present in the map
        for(Integer productId : productIds){
            if(!productMap.containsKey(productId)){
                throw new ProductPurchaseException("Product with Id: " + productId + " not found.");
            }
        }

        List<ProductPurchaseResponse> purchaseList = new ArrayList<>();

        for (ProductPurchaseRequest productRequest : request) {

            Product existingProduct = productMap.get(productRequest.id());
//
//            if (existingProduct == null) {
//                throw new ProductPurchaseException("Product with Id: " + productRequest.id() + " not found.");
//            }

            if (existingProduct.getAvailableQuantity() < productRequest.Quantity()) {
                throw new ProductPurchaseException(
                        "Available quantity is less than required for the Product with Id: " + productRequest.id());
            }

            // Update product stock
            existingProduct.setAvailableQuantity(existingProduct.getAvailableQuantity() - productRequest.Quantity());
            repository.save(existingProduct);

            // Convert to response
            purchaseList.add(mapper.convertToProductPurchaseResponse(existingProduct, productRequest.Quantity()));
        }

        return purchaseList;
    }

//    @Override
//    @Transactional(rollbackFor = ProductPurchaseException.class)
//    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
//
////        List<Integer> productIds = request.stream().map(ProductPurchaseRequest::id)
////                .collect(Collectors.toList());
//        List<ProductPurchaseResponse> purchaseList = new ArrayList<ProductPurchaseResponse>();
//
//        List<Integer> productIds = repository.findAll()
//                .stream()
//                        .map(Product::getId)
//                                .collect(Collectors.toList());
//
//        request.stream().forEach(product->{
//            if(!productIds.contains(product.id())){
//                throw new ProductPurchaseException(
//                        "Product with Id : " + product.id() + " not found.");
//            }
//
//            Product existingProduct = repository.findById(product.id()).get();
//
//
//            if( existingProduct.getAvailableQuantity() < product.Quantity()){
//                throw new ProductPurchaseException(
//                        "Available quantity is less than requirec for the Product with Id : "
//                                + product.id() + " not found.");
//            }else{
//                double newQuantity = existingProduct.getAvailableQuantity() - product.Quantity();
//                existingProduct.setAvailableQuantity(newQuantity);
//                repository.save(existingProduct);
//                purchaseList.add(mapper.convertToProductPurchaseResponse(existingProduct,product.Quantity()));
//
//            }
//        });
//
//        return purchaseList;
//    }

    @Override
    public ProductResponse findProductById(Integer productId) {
        return repository.findById(productId).map(mapper::convertToProductResponse)
                .orElseThrow(() ->
                        new ProductPurchaseException("Product with Id : " + productId + " not found.")
                );

//        return mapper.convertToProductResponse(product);
    }

    @Override
    public List<ProductResponse> findAllProducts() {
        List<Product> products = repository.findAll();

        return products
                .stream()
                .map(mapper::convertToProductResponse).collect(Collectors.toList());

    }
}
