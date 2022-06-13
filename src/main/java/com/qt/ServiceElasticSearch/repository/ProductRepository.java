package com.qt.ServiceElasticSearch.repository;

import com.qt.ServiceElasticSearch.model.ProductEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<ProductEntity, String> {
}
