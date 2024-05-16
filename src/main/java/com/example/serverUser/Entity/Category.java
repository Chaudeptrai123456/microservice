package com.example.serverUser.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryid;
    @Column(name="name",length = 100,nullable = false)
    private String name;
    @Column(name="type",length = 100,nullable = false)
    private String type;
    @ManyToMany(mappedBy = "categories")
    private Set<Product> productSet;

    public Set<Product> getProductSet() {
        return productSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
