package com.example.ecommerceapp.service;

import com.example.ecommerceapp.model.Products;
import com.example.ecommerceapp.resource.ProductDao;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.example.ecommerceapp.util.Utilities.missingRequiredFields;
import static com.example.ecommerceapp.util.Utilities.populateProductIdIfNotPresent;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ProductsService {
    private final ProductDao productDao;

    public ProductsService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Products> getProducts() {
        return productDao.findAll();
    }

    public Products getProduct(Long id) {
        return productDao.findProductsById(id);
    }

    public boolean productExist(Long id) {
        return !productDao.existsProductsById(id);
    }

    public Products addProduct(Products products) {
        return productDao.save(products);
    }

    public Products editProduct(Products product, Long productId) {
        populateProductIdIfNotPresent(product, productId);
        populateMissingFields(product);
        return productDao.save(product);
    }

    public void deleteProduct(Long id) {
        productDao.deleteById(id);
    }

    public void verifyProduct(Products products) {
        if (missingRequiredFields(products)) {
            throw new ResponseStatusException(BAD_REQUEST, "Missing required fields.");
        }
    }

    private void populateMissingFields(Products product) {
        Products existingProduct = getProduct(product.getId());
        if (product.getTitle() == null || product.getTitle().isEmpty()) {
            product.setTitle(existingProduct.getTitle());
        }
    }
}
