package com.qt.ServiceElasticSearch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Document(indexName = "table_products", type = "article")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEntity {

    @Id
    private String id;
    private String productId;

    private String productName;

    private String category;

    private Double price;

    private String startDateSell;

    private Integer quantity;

    private String description;



}

