package com.example.serverUser.Service.Elasticsearch;

import com.example.serverUser.DTO.FeatureDto;
import com.example.serverUser.DTO.ProductDTO;
import com.example.serverUser.Entity.Elasticsearch.FeatureElasticsearch;
import com.example.serverUser.Entity.Elasticsearch.ProductElasticSearch;
import com.example.serverUser.Entity.Product;
import com.example.serverUser.Repostitory.FeatureElasticsearchRepository;
import com.example.serverUser.Repostitory.ProductElasticSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ElasticsearchServiceImplement implements ElasticSearchService{
    @Autowired
    private  ProductElasticSearchRepository elasticSearchRepository;
    @Autowired
    private FeatureElasticsearchRepository featureElasticsearchRepository;
    @Override
    public void create(List<FeatureDto> list, Product product) {
        ProductElasticSearch productElasticSearch = new ProductElasticSearch();
        productElasticSearch.setName(product.getNameProduct());
        productElasticSearch.setPrice(product.getCost());
        List<FeatureElasticsearch> listFeature = new ArrayList<>();
        for (FeatureDto index:list) {
            FeatureElasticsearch featureElasticsearch = new FeatureElasticsearch();
            featureElasticsearch.setAttribute(index.getAttribute());
            featureElasticsearch.setValue(index.getValue());
            this.featureElasticsearchRepository.save(featureElasticsearch);
            listFeature.add(featureElasticsearch);
        }
        productElasticSearch.setList(listFeature);
        System.out.println("test elasticsearch " + productElasticSearch.getId()+ " " + productElasticSearch.getName() + " " + productElasticSearch.getPrice());
        this.elasticSearchRepository.save(productElasticSearch);
        Iterable<ProductElasticSearch> a = this.elasticSearchRepository.findAll();
        for (ProductElasticSearch index : a) {
            System.out.println("elasticsearch " + index.getId() + " name " + index.getName());
            System.out.println(index.getList().size());
        }
     }

    @Override
    public void update(ProductDTO productDTO) {
        System.out.println("test update elasticsearch "  + productDTO);

    }
}
