package com.example.serverUser.Service.Elasticsearch;

import com.example.serverUser.DTO.FeatureDto;
import com.example.serverUser.DTO.ProductDTO;
import com.example.serverUser.Entity.Product;

import java.util.List;

public interface ElasticSearchService {

    public void create(List<FeatureDto> list, Product product);
    public void update(ProductDTO productDTO);

}
