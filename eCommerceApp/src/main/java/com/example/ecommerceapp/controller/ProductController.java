package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.model.Products;
import com.example.ecommerceapp.service.ProductsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/product/{productId}")
public class ProductController {
    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Products getProduct(@PathVariable(value = "productId") Long productId) {
        checkForTheProduct(productId);
        return productsService.getProduct(productId);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Products editProduct(@PathVariable(value = "productId") Long productId,
                             @RequestBody Products product) {

        checkForTheProduct(productId);
        return productsService.editProduct(product, productId);
    }

    private void checkForTheProduct(Long productId) {
        if (productsService.productExist(productId)) {
            throw new ResponseStatusException(NOT_FOUND, "Product is not found.");
        }
    }
}
