package com.example.serverUser.DTO;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private String nameProduct;
    private Double cost;

    private int quantity;
    private Long inventoryID;
    private List<FeatureDto> featureList=new ArrayList<>();

    private List<CategoryDto> categoryDtoList = new ArrayList<>();

    public List<FeatureDto> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<FeatureDto> featureList) {
        this.featureList = featureList;
    }

    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Long inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<CategoryDto> getCategoryDtoList() {
        return categoryDtoList;
    }

    public void setCategoryDtoList(List<CategoryDto> categoryDtoList) {
        this.categoryDtoList = categoryDtoList;
    }

    @Override
    public String toString() {
        return this.nameProduct+ " " + this.quantity + " " + this.price;
    }
}
