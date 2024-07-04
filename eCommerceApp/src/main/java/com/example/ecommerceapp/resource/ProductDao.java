package com.example.ecommerceapp.resource;

import com.example.ecommerceapp.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Products, Long> {

    boolean existsProductsById(Long id);

    Products findProductsById(Long id);
}
