package com.example.serverUser.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="feature")
@Getter
@Setter
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long featureId;
    @Column(name="namefeature",nullable = false,length = 50)
    private String nameFeature;
    @Column(name="feature",nullable = false,length = 500)
    private String feature;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
    @OneToMany(mappedBy = "feature")
    private List<FeatureValue> listFeature = new ArrayList<>();

    public List<FeatureValue> getListFeature() {
        return listFeature;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setListFeature(List<FeatureValue> listFeature) {
        this.listFeature = listFeature;
    }

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    public String getNameFeature() {
        return nameFeature;
    }

    public void setNameFeature(String nameFeature) {
        this.nameFeature = nameFeature;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }


}
