package com.example.ecommerceapp.util;

import com.example.ecommerceapp.model.Products;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * Utility methods for the application.
 */
public class Utilities {

    private Utilities() {
    }

    public static void populateProductIdIfNotPresent(Products product, Long productId) {
        if (productId != null) {
            product.setId(productId);
        } else if (product.getId() == null) {
            product.setId(Long.parseLong(UUID.randomUUID().toString()));
        }
    }

    public static boolean missingRequiredFields(Products product) {
        return areAnyEmpty(product.getTitle());
    }

    public static boolean areAnyEmpty(String... fields) {
        return Stream.of(fields).anyMatch(StringUtils::isEmpty);
    }
}
