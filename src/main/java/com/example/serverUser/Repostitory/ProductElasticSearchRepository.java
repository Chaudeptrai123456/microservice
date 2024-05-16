package com.example.serverUser.Repostitory;

import com.example.serverUser.Entity.Elasticsearch.ProductElasticSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

@EnableReactiveElasticsearchRepositories
public interface ProductElasticSearchRepository extends ElasticsearchRepository<ProductElasticSearch,String> {
    @Query("{\"match\": {\"nameProduct\": {\"query\": \"?0\"}}}")
    Page<ProductElasticSearch> findByProductName(String name, Pageable pageable) ;


}
