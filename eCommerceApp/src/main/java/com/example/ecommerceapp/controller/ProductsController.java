package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.model.Products;
import com.example.ecommerceapp.service.ProductsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> getProducts() {
        return productsService.getProducts();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Products addProduct(@RequestBody Products products) {
        productsService.verifyProduct(products);
        return productsService.addProduct(products);
    }
}
