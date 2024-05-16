package com.example.serverUser.DTO.KafkaEvent;

import com.example.serverUser.Entity.Feature;
import com.example.serverUser.Entity.Product_Inventory;

import java.util.Set;

public class Product {

    private String nameProduct;

    private Long productId;
    private Double price;
    private Set<Product_Inventory> listInventory;
    private Set<Feature> listFeature;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Product_Inventory> getListInventory() {
        return listInventory;
    }

    public void setListInventory(Set<Product_Inventory> listInventory) {
        this.listInventory = listInventory;
    }

    public Set<Feature> getListFeature() {
        return listFeature;
    }

    public void setListFeature(Set<Feature> listFeature) {
        this.listFeature = listFeature;
    }

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}
