package com.example.ecommerceapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.springframework.lang.Nullable;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Nullable
    @Column(name = "price")
    private Double price;

    @Column(name = "storage_available")
    private Integer storageAvailable = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Nullable
    public Double getPrice() {
        return price;
    }

    public void setPrice(@Nullable Double price) {
        this.price = price;
    }

    public Integer getStorageAvailable() {
        if (storageAvailable == null)
            setStorageAvailable(0);
        return storageAvailable;
    }

    public void setStorageAvailable(@Nullable Integer storageAvailable) {
        this.storageAvailable = storageAvailable;
    }
}
