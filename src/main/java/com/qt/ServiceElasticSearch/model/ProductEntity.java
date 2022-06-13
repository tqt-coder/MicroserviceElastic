package com.qt.ServiceElasticSearch.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Document(indexName = "productindex")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    private String iD;

    @NotNull
    private String nameProduct;

    @NotNull
    private double priceProduct;

    @NotNull
    private long quanityProduct;

}
