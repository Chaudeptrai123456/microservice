package com.example.serverUser.Entity.Elasticsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.*;

import java.lang.Double;


@Data
@Document( indexName = "product")
public class ProductElasticSearch {
    @Id
    private String id;
    @MultiField(mainField = @Field(type = Text, fielddata = true), otherFields = { @InnerField(suffix = "verbatim", type = Keyword) })
    private String name;
    @Field(type = FieldType.Double, name = "price")
    private Double price;
    @Field(type = Nested, includeInParent = true)
    private List<FeatureElasticsearch> list  = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public List<FeatureElasticsearch> getList() {
        return list;
    }

    public void setList(List<FeatureElasticsearch> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.lang.Double getPrice() {
        return price;
    }

    public void setPrice(java.lang.Double price) {
        this.price = price;
    }
}
