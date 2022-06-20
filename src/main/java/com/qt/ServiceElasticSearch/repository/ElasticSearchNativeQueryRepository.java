package com.qt.ServiceElasticSearch.repository;

import com.qt.ServiceElasticSearch.model.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class ElasticSearchNativeQueryRepository {
    private static final String PRODUCT_INDEX = "table_products";
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    public SearchHits<ProductEntity> findProductByCategory(String category) throws Exception {
        try {
            QueryBuilder queryBuilder = QueryBuilders.matchQuery("category", category);

            Query searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();

            SearchHits<ProductEntity> productHits = elasticsearchOperations.search(searchQuery, ProductEntity.class, IndexCoordinates.of(PRODUCT_INDEX));

            return productHits;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
