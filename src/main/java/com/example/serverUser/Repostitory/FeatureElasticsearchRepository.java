package com.example.serverUser.Repostitory;

import com.example.serverUser.Entity.Elasticsearch.FeatureElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface FeatureElasticsearchRepository extends ElasticsearchRepository<FeatureElasticsearch,String> {
}
