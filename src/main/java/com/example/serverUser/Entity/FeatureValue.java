package com.example.serverUser.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="feature_value")
public class FeatureValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 50, nullable = false)
    private String name;
    @Column(name = "attribute",length = 50, nullable = false)
    private String attribute;
    @Column(name = "value",length = 50, nullable = false)
    private String value;
    @ManyToOne()
    @JoinColumn(name="feature_id",nullable = false)
    private Feature feature;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAttribute() {
        return attribute;
    }
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Feature getFeature() {
        return feature;
    }
    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
